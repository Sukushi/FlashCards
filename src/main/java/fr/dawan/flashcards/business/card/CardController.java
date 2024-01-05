package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cards")
public class CardController extends GenericController<CardDto, CardService> {
    public CardController(CardService service) {
        super(service);
    }
}
