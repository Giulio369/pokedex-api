package com.example.pokedexapi.dto;

import lombok.Data;

@Data // (Opcional: Lombok)
public class LoginRequest {
    private String login;
    private String senha;

    // Se não usar Lombok, adicione getters/setters
}