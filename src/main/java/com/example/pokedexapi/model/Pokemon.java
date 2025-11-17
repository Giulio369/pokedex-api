package com.example.pokedexapi.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "pokemon")
@Data
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   
    @jakarta.persistence.Column(unique = true)
    private String nome;

    private String tipo;

    // O login do usuário que cadastrou
    private String usuarioLogin;

    // Cria uma tabela separada para armazenar a lista de habilidades
    @ElementCollection 
    private List<String> habilidades;
}