package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PassageService extends GenericService<PassageDto> {
	
	Page<PassageDto> findByNiveauAndUserId(Niveau niveau, long userId, Pageable pageable);
	
	Page<PassageDto> findByUserId(long userId, Pageable pageable);
	
	void insertPassage(long userId, long cardId);

	// Besoin ? : Mettre à jour le niveau d'UN passage
	// 1 : +1 niveau
	// 2 : reset niveau
	void upNiveau(long passageId);
	void resetNiveau(long passageId);
	// Besoin ? : Mettre à jour la date à la date d'aujourd'hui
	void setToday(long passageId);
}
