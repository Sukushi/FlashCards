package fr.dawan.flashcards.services;

import fr.dawan.flashcards.entitites.Card;
import fr.dawan.flashcards.entitites.Niveau;
import fr.dawan.flashcards.entitites.Passage;
import fr.dawan.flashcards.entitites.User;
import fr.dawan.flashcards.repositories.PassageRepository;
import fr.dawan.flashcards.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassageService {

    private final PassageRepository repository;

    public List<Passage> findAll() {
        return repository.findAll();
    }

    public Passage getById(long id) {
        return repository.getById(id);
    }

    public List<Card> findByNiveauAndUserId(String niveau, long userId) {
        return repository.findByNiveauAndUserId(Niveau.valueOf(niveau),userId).stream().map(Passage::getCard).toList();
    }

}
