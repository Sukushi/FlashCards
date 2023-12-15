package fr.dawan.flashcards.repositories;

import fr.dawan.flashcards.entitites.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NiveauRepository extends JpaRepository<Niveau,Long> {
}
