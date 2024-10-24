package com.credpago.challenge.service;

import com.credpago.challenge.dto.CartDTO;
import com.credpago.challenge.dto.TransactionDTO;
import com.credpago.challenge.entity.Cart;
import com.credpago.challenge.entity.Client;
import com.credpago.challenge.entity.Product;
import com.credpago.challenge.repository.CartRepository;
import com.credpago.challenge.repository.ClientRepository;
import com.credpago.challenge.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    @Transactional(rollbackFor = Exception.class)
    public Cart addProductsToCard(CartDTO dto) {
        List<Product> products = productRepository.findAllByReferences(dto.productsIds());
        return cartRepository.save(Cart.builder()
                .cartId(UUID.randomUUID().toString())
                .clientId(clientRepository.findClientByCpf(dto.clientCpf()).orElseThrow(() -> new RuntimeException("Client not found")))
                .products(products)
                .dateAndTime(LocalDateTime.now().toString())
                .totalPrice(calculateTotalPrice(products))
                .build());
    }

    public Double calculateTotalPrice(List<Product> products){
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

}
