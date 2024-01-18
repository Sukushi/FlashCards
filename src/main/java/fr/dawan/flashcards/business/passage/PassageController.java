package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.card.CardDto;
import fr.dawan.flashcards.business.generic.GenericController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("passages")
// localhost:8080/users -> display user's table
// localhost:8080/users/{id} -> display user's information from user.id = id
public class PassageController extends GenericController<PassageDto, PassageService> {
	
	public PassageController(PassageService service) {
		super(service);
	}
	
	@GetMapping("/niveau/{niveau}/{userId}")
    // localhost:8080/passages/niveau/NIVEAU2/1
    public Page<CardDto> findByNiveauAndUserId(@PathVariable String niveau, @PathVariable long userId, Pageable pageable) {
        return null; //service.findByNiveauAndUserId(Niveau.valueOf(niveau),userId, pageable).map(Passage::getCard);
    }
	
	@GetMapping("user/{userId}")
	// localhost:8080/passages/user/1
	public Page<PassageDto> findByUserId(@PathVariable long userId, Pageable pageable) {
		return service.findByUserId(userId,pageable);
	}

}
