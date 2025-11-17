package com.example.pokedexapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class DashboardStats {
    private long pokemonCount;
    private List<String> topTypes;
    private List<String> topAbilities;
}