package fr.dawan.flashcards.passage;

import fr.dawan.flashcards.entitites.Niveau;
import fr.dawan.flashcards.passage.Passage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassageRepository extends JpaRepository<Passage,Long> {

    Page<Passage> findByNiveauAndUserId(Niveau niveau, long userId, Pageable pageable);
	
	Page<Passage> findByUserId(long userId, Pageable pageable);

}
