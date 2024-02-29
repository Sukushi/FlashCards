package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface PassageService extends GenericService<PassageDto> {

	// FindByNiveau pour un User : prend l'id en paramètre et le pageable de <PassageDto>
	Page<PassageDto> findByNiveauAndUserId(Niveau niveau, long userId, Pageable pageable);
	
	Page<PassageDto> findByUserId(long userId, Pageable pageable);

	PassageDto insertPassage(long userId, long cardId, Niveau niveau, LocalDate date);

	// Fonction qui fait évoluer le passage en mettant à jour le niveau au niveau suivant
	void upNiveau(long passageId);
	// Fonction qui remet le passage au premier niveau
	void resetNiveau(long passageId);
	
	List<PassageDto> getDailyAll(long userId);
	
	PassageDto getDaily(long userId);
}
