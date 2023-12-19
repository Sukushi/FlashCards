package fr.dawan.flashcards.passage;

import fr.dawan.flashcards.card.Card;
import fr.dawan.flashcards.entitites.Niveau;
import fr.dawan.flashcards.generic.GenericController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("passages")
// localhost:8080/users -> display user's table
// localhost:8080/users/{id} -> display user's information from user.id = id
public class PassageController extends GenericController<Passage, PassageService> {
	
	public PassageController(PassageService service) {
		super(service);
	}
	
	@GetMapping("/niveau/{niveau}/{userId}")
    // localhost:8080/passages/niveau/NIVEAU2/1
    public Page<Card> findByNiveauAndUserId(@PathVariable String niveau, @PathVariable long userId, Pageable pageable) {
        return service.findByNiveauAndUserId(Niveau.valueOf(niveau),userId, pageable).map(Passage::getCard);
    }
	
	@GetMapping("user/{userId}")
	// localhost:8080/passages/user/1
	public Page<Passage> findByUserId(@PathVariable long userId, Pageable pageable) {
		return service.findByUserId(userId,pageable);
	}

}
