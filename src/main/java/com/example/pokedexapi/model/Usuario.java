package com.example.pokedexapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data; // Se você adicionou Lombok

// @Entity diz ao JPA que esta classe é uma tabela
@Entity
@Table(name = "usuarios") // Nome da tabela no BD
@Data // (Opcional: Lombok para getters/setters)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincrementado
    private Long id;

    private String login;
    private String senha;

    // Se não usar Lombok, adicione getters e setters aqui
    // public Long getId() { ... }
    // public void setId(Long id) { ... }
    // ... etc
}