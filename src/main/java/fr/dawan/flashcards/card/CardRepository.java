package fr.dawan.flashcards.card;

import fr.dawan.flashcards.card.Card;
import fr.dawan.flashcards.entitites.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {

	
}
