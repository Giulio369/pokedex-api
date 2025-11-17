package com.example.pokedexapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // (Opcional: Lombok)
@AllArgsConstructor // (Opcional: Lombok para criar um construtor)
public class LoginResponse {
    private boolean success;
    private String message;

    // Se não usar Lombok, crie o construtor e os getters/setters
}