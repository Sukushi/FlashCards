package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.GenericControllerREST;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/cards")
public class CardControllerREST extends GenericControllerREST<CardDto, CardService> {
    public CardControllerREST(CardService service) {
        super(service);
    }
	
	@GetMapping("/init")
	public ResponseEntity<String> init() {
		if (service.findAll(PageRequest.of(0,10)).getTotalElements() == 0) {
			service.init();
			return ResponseEntity.status(HttpStatus.OK).body("Les premières cartes ont été ajoutées");
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Les premières cartes ont déjà été ajoutées !");
	}
	
	@GetMapping("/categories")
	public List<Category> getCategories() {
		return Arrays.stream(Category.values()).toList();
	}
	
}
