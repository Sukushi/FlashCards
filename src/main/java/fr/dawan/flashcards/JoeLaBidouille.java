package fr.dawan.flashcards;

import fr.dawan.flashcards.business.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@Slf4j
public class JoeLaBidouille {
    public static void main(String[] args) {
        System.out.println("\tBienvenue dans la Page de Config de Joe\n");
        // Test d'un log
        log.info("Je lance la Spring Application : Run ");
        SpringApplication.run(JoeLaBidouille.class, args);

        // Data for Joe
        String name = "Joe";
        String password = "Joespassword";
        String email = "joe@email.com";
        User joe = new User(name,password,email);
        joe.setRole("USER");

        // Data from csv


        // Création d'un SUPER USER
        User superJoe = new User("admin", "admin", "admin@email.com");
        superJoe.setRole("ADMIN");

        // Connexion - Authentification

        joe.getAuthorities();

        // Affichage

        // Création d'une carte

    }
}
