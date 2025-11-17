package com.example.pokedexapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // Cria o construtor (public GenericApiResponse(boolean success, String message))
@NoArgsConstructor  // Cria um construtor vazio
public class GenericApiResponse {

    private boolean success;
    private String message;

    // Se não usar Lombok, adicione os construtores e getters/setters
}