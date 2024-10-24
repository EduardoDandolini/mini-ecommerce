package com.credpago.challenge.controller.impl;

import com.credpago.challenge.controller.CartController;
import com.credpago.challenge.dto.CartDTO;
import com.credpago.challenge.entity.Cart;
import com.credpago.challenge.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/api/v1")
@RequiredArgsConstructor
public class CartControllerImpl implements CartController {

    private final CartService cartService;


    @Override
    @PostMapping("/add_to_cart")
    public ResponseEntity<Cart> addProductsToCart(@RequestBody CartDTO dto) {
        return ResponseEntity.ok(cartService.addProductsToCard(dto));
    }
}
