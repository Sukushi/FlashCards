package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.GenericServiceMapper;
import org.springframework.stereotype.Service;

@Service
public class CardServiceMapper extends GenericServiceMapper<Card,CardRepository> {
	public CardServiceMapper(CardRepository repository) {
		super(repository);
	}
}
