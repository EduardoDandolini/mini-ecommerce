package com.credpago.challenge.dto;

import com.credpago.challenge.entity.Cart;
import com.credpago.challenge.entity.Client;
import com.credpago.challenge.entity.CreditCard;

public record TransactionConverterDTO(
        Client clientId,
        Cart cart,
        Double totalToPay,
        CreditCard creditCard
) {
}
