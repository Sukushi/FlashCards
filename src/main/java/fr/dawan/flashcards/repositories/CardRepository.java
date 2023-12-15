package fr.dawan.flashcards.repositories;

import fr.dawan.flashcards.entitites.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
