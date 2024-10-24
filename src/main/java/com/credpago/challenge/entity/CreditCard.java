package com.credpago.challenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @Id
    private String cardNumber;

    private String cardHolderName;

    private Integer cvv;

    private String expDate;

}
