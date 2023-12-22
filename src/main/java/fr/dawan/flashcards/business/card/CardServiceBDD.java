package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.GenericServiceBDD;
import fr.dawan.flashcards.business.entitites.Niveau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CardServiceBDD extends GenericServiceBDD<Card,CardRepository,CardDto,CardMapper> implements CardService {

    private final CardMapper cardMapper;

    public CardServiceBDD(CardRepository repository,CardMapper mapper,
                          CardMapper cardMapper){
        super(repository, mapper);

        this.cardMapper = cardMapper;
    }

    @Override
    public Page<CardDto> findById(long id, Pageable pageable) {
        return repository.findById(id, pageable).map(cardMapper::toDto);
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
