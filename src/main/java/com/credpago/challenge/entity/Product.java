package com.credpago.challenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable {

    @Id
    private String productId;

    private String artist;

    private Integer year;

    private String album;

    private Double price;

    private String store;

    private String thumb;

    private String date;

    @Column(unique = true)
    private String reference;

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;
}
