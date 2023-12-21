package fr.dawan.flashcards.card;

import fr.dawan.flashcards.card.Card;
import fr.dawan.flashcards.card.CardRepository;
import fr.dawan.flashcards.entitites.Category;
import fr.dawan.flashcards.entitites.Niveau;
import fr.dawan.flashcards.generic.GenericServiceBDD;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceBDD extends GenericServiceBDD<Card,CardRepository,CardDto,CardMapper> implements CardService {

	public CardServiceBDD(CardRepository repository,CardMapper mapper){
        super(repository, mapper);

    }

    @Override
    public Page<CardDto> findById(long id, Pageable pageable) {
        return repository.findById(id,pageable).map(mapper::toDto);
    }

    @Override
    public Page<CardDto> findByTitle(String title, Pageable pageable) {
        return repository.findByTitle(title,pageable).map(mapper::toDto);
    }

    @Override
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
    }
}
