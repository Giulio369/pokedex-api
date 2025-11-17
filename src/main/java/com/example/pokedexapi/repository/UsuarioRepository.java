package com.example.pokedexapi.repository;

import com.example.pokedexapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // O Spring Data JPA cria a consulta SQL automaticamente
    // com base no nome do método.
    // Isso é o equivalente a: SELECT * FROM usuarios WHERE login = ?
    Optional<Usuario> findByLogin(String login);
}