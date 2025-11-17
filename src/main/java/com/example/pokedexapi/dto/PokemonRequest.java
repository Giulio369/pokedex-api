package com.example.pokedexapi.dto;

import lombok.Data;
import java.util.List;

@Data
public class PokemonRequest {
    private String nome;
    private String tipo;
    private List<String> habilidades;
    private String usuarioLogin;
}