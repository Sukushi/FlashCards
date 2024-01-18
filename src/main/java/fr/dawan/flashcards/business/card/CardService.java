package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CardService extends GenericService<CardDto> {
	Page<CardDto> findById(long id, Pageable pageable);

	Page<CardDto> findByTitle(String title, Pageable pageable);
	
	void init();
	/*Page<CardDto> findByCategory(String category, Pageable pageable);
	Page<CardDto> findByKeywords(String word, Pageable pageable);
	Page<CardDto> findByNiveau(Niveau niveau, Pageable pageable);*/

}
