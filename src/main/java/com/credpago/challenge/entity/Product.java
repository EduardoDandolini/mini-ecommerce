package com.credpago.challenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

    private Integer price;

    private String store;

    private String thumb;

    private String date;

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;
}
