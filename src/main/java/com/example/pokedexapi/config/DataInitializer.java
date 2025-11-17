package com.example.pokedexapi.config;

import com.example.pokedexapi.model.Pokemon; // Importe o Pokemon
import com.example.pokedexapi.model.Usuario;
import com.example.pokedexapi.repository.PokemonRepository; // Importe o Repo
import com.example.pokedexapi.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List; // Importe o List

@Configuration
public class DataInitializer {

    // Este @Bean cria um CommandLineRunner, que o Spring executa
    // automaticamente assim que o servidor liga.
    @Bean
    public CommandLineRunner loadData(UsuarioRepository usuarioRepository, 
                                      PokemonRepository pokemonRepository) { // 1. Injete o PokemonRepository
        return args -> {
            if (usuarioRepository.count() == 0) {
            // --- Requisito: Cadastrar 3 usuários previamente ---
            System.out.println("Cadastrando 3 usuários...");

            Usuario user1 = new Usuario();
            user1.setLogin("Giulio");
            user1.setSenha("giulio123"); 
            usuarioRepository.save(user1);

            Usuario user2 = new Usuario();
            user2.setLogin("Diego");
            user2.setSenha("diego123");
            usuarioRepository.save(user2);

            Usuario user3 = new Usuario();
            user3.setLogin("Andre");
            user3.setSenha("andre123");
            usuarioRepository.save(user3);

            System.out.println("Usuários cadastrados!");
            } else {
                System.out.println("Usuários já existem no banco, pulando criação.");
            }

        if (pokemonRepository.count() == 0) {
            // --- Requisito: Cadastrar 10 Pokémons previamente ---
            System.out.println("Cadastrando 10 Pokémons...");

            // Dados baseados nos resultados de pokemon.com
            
            Pokemon p1 = new Pokemon();
            p1.setNome("Charmander");
            p1.setTipo("Fogo");
            p1.setHabilidades(List.of("Blaze"));
            p1.setUsuarioLogin("Giulio"); // Cadastrado por 'Giulio'
            pokemonRepository.save(p1);

            Pokemon p2 = new Pokemon();
            p2.setNome("Venusaur");
            p2.setTipo("Grama, Veneno");
            p2.setHabilidades(List.of("Overgrow"));
            p2.setUsuarioLogin("Giulio");
            pokemonRepository.save(p2);

            Pokemon p3 = new Pokemon();
            p3.setNome("Charizard");
            p3.setTipo("Fogo, Voador");
            p3.setHabilidades(List.of("Blaze"));
            p3.setUsuarioLogin("Giulio");
            pokemonRepository.save(p3);
            
            Pokemon p4 = new Pokemon();
            p4.setNome("Butterfree");
            p4.setTipo("Inseto, Voador");
            p4.setHabilidades(List.of("Compound Eyes"));
            p4.setUsuarioLogin("Diego"); // Cadastrado por 'Diego'
            pokemonRepository.save(p4);

            Pokemon p5 = new Pokemon();
            p5.setNome("Tyranitar");
            p5.setTipo("Pedra, Sombrio");
            p5.setHabilidades(List.of("Sand Stream"));
            p5.setUsuarioLogin("Andre"); // Cadastrado por 'Andre'
            pokemonRepository.save(p5);
            
            Pokemon p6 = new Pokemon();
            p6.setNome("Dragonite");
            p6.setTipo("Dragão, Voador");
            p6.setHabilidades(List.of("Inner Focus"));
            p6.setUsuarioLogin("Giulio");
            pokemonRepository.save(p6);

            Pokemon p7 = new Pokemon();
            p7.setNome("Muk");
            p7.setTipo("Veneno");
            p7.setHabilidades(List.of("Stench", "Sticky Hold"));
            p7.setUsuarioLogin("Diego");
            pokemonRepository.save(p7);

            Pokemon p8 = new Pokemon();
            p8.setNome("Glalie");
            p8.setTipo("Gelo");
            p8.setHabilidades(List.of("Inner Focus", "Ice Body"));
            p8.setUsuarioLogin("Diego");
            pokemonRepository.save(p8);

            Pokemon p9 = new Pokemon();
            p9.setNome("Milotic");
            p9.setTipo("Água");
            p9.setHabilidades(List.of("Marvel Scale", "Competitive"));
            p9.setUsuarioLogin("Diego");
            pokemonRepository.save(p9);

            Pokemon p10 = new Pokemon();
            p10.setNome("Arceus");
            p10.setTipo("Normal");
            p10.setHabilidades(List.of("Multitype"));
            p10.setUsuarioLogin("Giulio");
            pokemonRepository.save(p10);

            System.out.println("10 Pokémons cadastrados!");
        } else {
                System.out.println("Pokémons já existem no banco, pulando criação.");
            }
        };
    }
}