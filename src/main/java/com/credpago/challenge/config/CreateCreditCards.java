package com.credpago.challenge.config;

import com.credpago.challenge.entity.CreditCard;
import com.credpago.challenge.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CreateCreditCards implements CommandLineRunner {

    private final CreditCardRepository creditCardRepository;

    @Override
    public void run(String... args) throws Exception {
        creditCardRepository.save(CreditCard.builder()
                .cardNumber("123456789")
                .cardHolderName("John Doe")
                .cvv(123)
                .expDate("01/01/2025")
                .build());

        creditCardRepository.save(CreditCard.builder()
                .cardNumber("987654321")
                .cardHolderName("Teste")
                .cvv(999)
                .expDate("01/01/2025")
                .build());

    }
}
