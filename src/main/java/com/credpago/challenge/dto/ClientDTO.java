package com.credpago.challenge.dto;

import org.hibernate.validator.constraints.br.CPF;

public record ClientDTO(
        String name,

        @CPF
        String cpf
) {
}
