package com.credpago.challenge.dto;

public record ProductDTO(
        String artist,
        Integer year,
        String album,
        Double price,
        String store,
        String thumb,
        String date,
        String reference
) {
}
