package fr.dawan.flashcards.services;

import fr.dawan.flashcards.entitites.Card;
import fr.dawan.flashcards.entitites.User;
import fr.dawan.flashcards.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
	
	private final CardRepository repository;
	
	public List<Card> findAll() {
		return repository.findAll();
	}
	public Card findById(long id) {
		return repository.findById(id).orElse(null);
	}

}
