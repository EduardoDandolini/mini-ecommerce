package com.credpago.challenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction implements Serializable {

    @Id
    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

    private Integer totalToPay;

    @ManyToOne
    @JoinColumn(name = "credit_card_Id")
    private CreditCard creditCard;

}
