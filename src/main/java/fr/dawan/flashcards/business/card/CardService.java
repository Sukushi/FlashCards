package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.GenericService;
import fr.dawan.flashcards.business.entitites.Niveau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CardService extends GenericService<CardDto> {
    Page<CardDto> findById(long id, Pageable pageable);

    Page<CardDto> findByTitle(String title, Pageable pageable);
    Page<CardDto> findByCategory(String category, Pageable pageable);
    Page<CardDto> findByKeywords(String word, Pageable pageable);
    Page<CardDto> findByNiveau(Niveau niveau, Pageable pageable);

}
