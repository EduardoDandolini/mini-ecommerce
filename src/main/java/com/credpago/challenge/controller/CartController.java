package com.credpago.challenge.controller;

import com.credpago.challenge.dto.CartDTO;
import com.credpago.challenge.entity.Cart;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface CartController {

    @Operation(
            summary = "Add products to cart",
            description = "Adds products to cart using the data provided in the CartDTO."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Products added to cart successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Cart> addProductsToCart(CartDTO dto);
}
