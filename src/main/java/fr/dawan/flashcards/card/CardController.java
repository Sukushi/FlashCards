package fr.dawan.flashcards.card;

import fr.dawan.flashcards.entitites.Category;
import fr.dawan.flashcards.generic.GenericController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cards")
public class CardController extends GenericController<CardDto, CardService> {
	public CardController(CardService service) {
		super(service);
	}
}
