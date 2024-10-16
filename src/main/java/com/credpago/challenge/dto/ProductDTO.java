package com.credpago.challenge.dto;

public record ProductDTO(
        String artist,
        Integer year,
        String album,
        Integer price,
        String store,
        String thumb,
        String date
) {
}
