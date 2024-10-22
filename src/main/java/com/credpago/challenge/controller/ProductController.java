package com.credpago.challenge.controller;

import com.credpago.challenge.dto.ProductDTO;
import com.credpago.challenge.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController {

    @Operation(summary = "Create a new product", description = "Creates a new product using the data provided in the ProductDTO.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Product> createProduct(ProductDTO dto);

    @Operation(summary = "Get list of products", description = "Returns a list of all products in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of products retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No products found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<List<ProductDTO>> getProducts();

}
