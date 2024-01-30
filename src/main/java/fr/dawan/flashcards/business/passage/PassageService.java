package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PassageService extends GenericService<PassageDto> {

	// FindByNiveau pour un User : prend l'id en paramètre et le pageable de <PassageDto>
	Page<PassageDto> findByNiveauAndUserId(Niveau niveau, long userId, Pageable pageable);
	
	Page<PassageDto> findByUserId(long userId, Pageable pageable);

	// TODO Svp tu peux me dire ce que c'est ça ? Romain ? C'est genre setPassage ?
	void insertPassage(long userId, long cardId);

	// Fonction qui fait évoluer le passage en mettant à jour le niveau au niveau suivant
	void upNiveau(long passageId);
	// Fonction qui remet le passage au premier niveau
	void resetNiveau(long passageId);
}
