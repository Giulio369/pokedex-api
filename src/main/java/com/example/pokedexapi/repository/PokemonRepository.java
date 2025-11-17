package com.example.pokedexapi.repository;

import com.example.pokedexapi.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    // (O Spring cria a query: SELECT * FROM pokemon WHERE nome = ?)
    Optional<Pokemon> findByNome(String nome);


    List<Pokemon> findByTipoContainingIgnoreCase(String tipo);

    // Query customizada para buscar por habilidade (requisito pedia LIKE)
    // Isso busca Pokémons onde a 'habilidade' está na lista 'habilidades'
    @Query("SELECT p FROM Pokemon p JOIN p.habilidades h WHERE h LIKE %:habilidade%")
    List<Pokemon> findByHabilidade(String habilidade);
}