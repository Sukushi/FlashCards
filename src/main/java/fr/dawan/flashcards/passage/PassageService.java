package fr.dawan.flashcards.passage;

import fr.dawan.flashcards.entitites.Niveau;
import fr.dawan.flashcards.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PassageService extends GenericService<Passage> {
	
	Page<Passage> findByNiveauAndUserId(Niveau niveau, long userId, Pageable pageable);
	
	Page<Passage> findByUserId(long userId, Pageable pageable);
}
