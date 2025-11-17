package com.example.pokedexapi.controller;

import com.example.pokedexapi.dto.LoginRequest;
import com.example.pokedexapi.dto.LoginResponse;
import com.example.pokedexapi.model.Usuario;
import com.example.pokedexapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping // (O prefixo /api já está em application.properties)
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Isso cria o endpoint: POST http://localhost:8080/api/login
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        
        // 1. Busca o usuário no banco pelo login
        Optional<Usuario> usuarioOptional = usuarioRepository.findByLogin(loginRequest.getLogin());

        // 2. Verifica se o usuário existe
        if (usuarioOptional.isEmpty()) {
            // Usuário não encontrado
            return ResponseEntity.ok(new LoginResponse(false, "Login ou Senha incorretos"));
        }

        // 3. Verifica se a senha bate
        Usuario usuario = usuarioOptional.get();
        if (!usuario.getSenha().equals(loginRequest.getSenha())) {
            // Senha errada
            return ResponseEntity.ok(new LoginResponse(false, "Login ou Senha incorretos"));
        }

        // 4. Sucesso
        return ResponseEntity.ok(new LoginResponse(true, "Login bem-sucedido!"));
    }
}