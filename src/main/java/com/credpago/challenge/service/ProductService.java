package com.credpago.challenge.service;

import com.credpago.challenge.dto.ProductDTO;
import com.credpago.challenge.entity.Product;
import com.credpago.challenge.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(rollbackFor = Exception.class)
    public Product addProduct(ProductDTO dto) {
        return productRepository.save(Product.builder()
                .productId(UUID.randomUUID().toString())
                .album(dto.album())
                .artist(dto.artist())
                .price(dto.price())
                .store(dto.store())
                .thumb(dto.thumb())
                .year(dto.year())
                .build());
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private ProductDTO toDto(Product product) {
        return new ProductDTO(
                product.getArtist(),
                product.getYear(),
                product.getAlbum(),
                product.getPrice(),
                product.getStore(),
                product.getThumb(),
                product.getDate()
        );
    }
}
