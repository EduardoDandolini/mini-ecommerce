package com.credpago.challenge.repository;

import com.credpago.challenge.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, String> {

    Optional<CreditCard> findByCardNumber(String cardNumber);
}
