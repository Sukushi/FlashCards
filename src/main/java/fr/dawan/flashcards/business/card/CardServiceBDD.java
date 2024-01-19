package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.GenericServiceBDD;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceBDD extends GenericServiceBDD<Card,CardRepository,CardDto,CardMapper> implements CardService {
	
    public CardServiceBDD(CardRepository repository,CardMapper mapper){
        super(repository, mapper);
    }

    @Override
    public Page<CardDto> findById(long id, Pageable pageable) {
        return repository.findById(id, pageable).map(mapper::toDto);
    }
	
	// méthode pour le mapping
	public Card getById(long cardId) {
		return repository.findById(cardId).get();
	}

    @Override
    public Page<CardDto> findByTitle(String title, Pageable pageable) {
        return repository.findByTitle(title,pageable).map(mapper::toDto);
    }
	
	@Override
	public void init() {
		List<Card> cards = initCard();
		cards.forEach(repository::save);
	}
	
	private List<Card> initCard() {
		return List.of(
				new Card("Dependance",Category.JAVA,"Qu'est qu'une dépendance ?","Une dépendance c'est..."),
				new Card("Implementation",Category.JAVA,"Qu'est qu'une implémentation ?","Une implémentation c'est...")
		);
	}

	/*@Override
	public Page<CardDto> findByCategory(String category, Pageable pageable) {
		return null;
	}

	@Override
	public Page<CardDto> findByKeywords(String word, Pageable pageable) {
		return null;
	}

	@Override
	public Page<CardDto> findByNiveau(Niveau niveau, Pageable pageable) {
		return null;
	}*/
}
