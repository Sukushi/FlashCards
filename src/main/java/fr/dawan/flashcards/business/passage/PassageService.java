package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.generic.GenericService;
import fr.dawan.flashcards.business.entitites.Niveau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PassageService extends GenericService<PassageDto> {
	
	Page<PassageDto> findByNiveauAndUserId(Niveau niveau, long userId, Pageable pageable);
	
	Page<PassageDto> findByUserId(long userId, Pageable pageable);
}
