package fr.dawan.flashcards.repositories;

import fr.dawan.flashcards.entitites.Niveau;
import fr.dawan.flashcards.entitites.Passage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassageRepository extends JpaRepository<Passage,Long> {

    List<Passage> findByNiveauAndUserId(Niveau niveau, long userId);

}
