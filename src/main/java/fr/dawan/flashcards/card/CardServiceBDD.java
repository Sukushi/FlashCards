package fr.dawan.flashcards.card;

import fr.dawan.flashcards.card.Card;
import fr.dawan.flashcards.card.CardRepository;
import fr.dawan.flashcards.entitites.Category;
import fr.dawan.flashcards.generic.GenericServiceBDD;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceBDD extends GenericServiceBDD<Card,CardRepository> implements CardService {
	
	public CardServiceBDD(CardRepository repository) {
		super(repository);
	}
	
}
