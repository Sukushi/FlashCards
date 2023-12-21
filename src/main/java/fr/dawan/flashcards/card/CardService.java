package fr.dawan.flashcards.card;

import fr.dawan.flashcards.entitites.Category;
import fr.dawan.flashcards.entitites.Niveau;
import fr.dawan.flashcards.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CardService extends GenericService<CardDto> {
    Page<CardDto> findById(long id, Pageable pageable);

    Page<CardDto> findByTitle(String title, Pageable pageable);
    Page<CardDto> findByCategory(String category, Pageable pageable);
    Page<CardDto> findByKeywords(String word, Pageable pageable);
    Page<CardDto> findByNiveau(Niveau niveau, Pageable pageable);

}
