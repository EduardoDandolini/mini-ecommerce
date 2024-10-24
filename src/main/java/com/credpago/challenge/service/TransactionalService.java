package com.credpago.challenge.service;

import com.credpago.challenge.dto.TransactionConverterDTO;
import com.credpago.challenge.dto.TransactionDTO;
import com.credpago.challenge.entity.Cart;
import com.credpago.challenge.entity.Client;
import com.credpago.challenge.entity.CreditCard;
import com.credpago.challenge.entity.Transaction;
import com.credpago.challenge.repository.CartRepository;
import com.credpago.challenge.repository.ClientRepository;
import com.credpago.challenge.repository.CreditCardRepository;
import com.credpago.challenge.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionalService {

    private final TransactionRepository transactionRepository;
    private final ClientRepository clientRepository;
    private final CartRepository cartRepository;
    private final CreditCardRepository creditCardRepository;

    @Transactional(rollbackFor = Exception.class)
    public Transaction buy(TransactionDTO dto) {
        Client client = clientRepository.findClientByCpf(dto.cpf()).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        Cart cart = cartRepository.findCartByClientId(client.getClientId()).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
        CreditCard creditCard = creditCardRepository.findByCardNumber(dto.cardNumber()).orElseThrow(() -> new EntityNotFoundException("Credit card not found"));
        return transactionRepository.save(Transaction.builder()
                .transactionId(UUID.randomUUID().toString())
                .clientId(client)
                .cart(cart)
                .creditCard(creditCard)
                .totalToPay(cart.getTotalPrice())
                .build());
    }

    @Transactional(readOnly = true)
    public List<TransactionConverterDTO> getTransactions(){
        return transactionRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private TransactionConverterDTO toDto(Transaction transaction){
        return new TransactionConverterDTO(
                transaction.getClientId(),
                transaction.getCart(),
                transaction.getTotalToPay(),
                transaction.getCreditCard()
        );
    }
}
