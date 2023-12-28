package fr.dawan.flashcards;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class JoeLaBidouille {
    public static void main(String[] args) {
        System.out.println("\tBienvenue dans la Page de Config de Joe\n");
        // Test d'un log
        log.info("Je lance la Spring Application : Run ");
        SpringApplication.run(JoeLaBidouille.class, args);


    }
}
