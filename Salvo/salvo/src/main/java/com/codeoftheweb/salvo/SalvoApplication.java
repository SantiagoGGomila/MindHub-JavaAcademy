package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SalvoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SalvoApplication.class, args);
    }


    @Bean
    public CommandLineRunner initData(PlayerRepository repository, GameRepository gameRepo, GamePlayerRepository gamePlayerRepo, ShipRepository shipRepo) {
        return (args) -> {

            Player player1=new Player("saggomila@gmail.com");
            Player player2=new Player("santi@gmail.com");

            Game game1=new Game(LocalDateTime.now());
            Game game2=new Game(LocalDateTime.now().plusHours(1));

            GamePlayer gamePlayer1 = new GamePlayer(game1, player1, LocalDateTime.now());
            GamePlayer gamePlayer2 = new GamePlayer(game1, player2, LocalDateTime.now());



            Ship ship1 = new Ship(gamePlayer1, "Submarine", List.of("J5", "J6", "J7") );
            Ship ship2 = new Ship(gamePlayer1, "Carrier", List.of("B5", "B6", "B7", "B8", "B9") );


            repository.save(player1);
            repository.save(player2);
            gameRepo.save(game1);
            gameRepo.save(game2);
            gamePlayerRepo.save(gamePlayer1);
            gamePlayerRepo.save(gamePlayer2);
            shipRepo.save(ship1);
            shipRepo.save(ship2);




        };
    }
}