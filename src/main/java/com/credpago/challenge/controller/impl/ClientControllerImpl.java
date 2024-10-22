package com.credpago.challenge.controller.impl;

import com.credpago.challenge.controller.ClientController;
import com.credpago.challenge.dto.ClientDTO;
import com.credpago.challenge.entity.Client;
import com.credpago.challenge.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/api/v1")
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {

    private final ClientService service;

    @Override
    @PostMapping("/client")
    public ResponseEntity<Client> createClient(ClientDTO dto) {
        return ResponseEntity.ok(service.createClient(dto));
    }
}
