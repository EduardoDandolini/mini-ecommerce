package com.credpago.challenge.controller.impl;

import com.credpago.challenge.controller.ProductController;
import com.credpago.challenge.dto.ProductDTO;
import com.credpago.challenge.entity.Product;
import com.credpago.challenge.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store/api/v1")
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

    private final ProductService service;

    @Override
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO dto) {
        return ResponseEntity.ok(service.createProduct(dto));
    }

    @Override
    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return ResponseEntity.ok(service.getProducts());
    }
}
