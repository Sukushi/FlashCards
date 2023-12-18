package fr.dawan.flashcards.repositories;


import fr.dawan.flashcards.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
