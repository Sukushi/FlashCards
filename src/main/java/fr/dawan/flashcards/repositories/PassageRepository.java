package fr.dawan.flashcards.repositories;

import fr.dawan.flashcards.entitites.Passage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassageRepository extends JpaRepository<Passage,Long> {
}
