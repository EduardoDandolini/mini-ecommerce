package com.credpago.challenge.entity;

import jakarta.persistence.Entity;
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
public class CreditCard implements Serializable {

    private String cardNumber;
    private String cardHolderName;
    private Integer cvv;
    private String expDate;
}
