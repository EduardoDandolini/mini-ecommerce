package com.credpago.challenge.dto;

import java.util.List;

public record CartDTO(
        String clientCpf,
        List<String> productsIds
) {
}
