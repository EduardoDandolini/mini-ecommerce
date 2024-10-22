package com.credpago.challenge.controller;

import com.credpago.challenge.dto.ClientDTO;
import com.credpago.challenge.entity.Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface ClientController {

    @Operation(
            summary = "Create a new client",
            description = "Creates a new client using the data provided in the ClientDTO."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Client> createClient(ClientDTO dto);
}
