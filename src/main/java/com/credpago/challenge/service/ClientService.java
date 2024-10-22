package com.credpago.challenge.service;

import com.credpago.challenge.dto.ClientDTO;
import com.credpago.challenge.entity.Client;
import com.credpago.challenge.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional(rollbackFor = Exception.class)
    public Client createClient(ClientDTO dto) {
        return clientRepository.save(
                Client.builder()
                        .clientId(UUID.randomUUID().toString())
                        .name(dto.name())
                        .cpf(dto.cpf())
                        .build()
        );
    }
}
