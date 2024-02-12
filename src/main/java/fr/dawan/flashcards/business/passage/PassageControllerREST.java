package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.generic.GenericControllerREST;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/passages")
public class PassageControllerREST extends GenericControllerREST<PassageDto, PassageService> {
	
	public PassageControllerREST(PassageService service) {
		super(service);
	}
	
	@GetMapping("/niveau/{niveau}/{userId}")
    /* localhost:8080/passages/niveau/NIVEAU2/1 */
    public Page<PassageDto> findByNiveauAndUserId(@PathVariable String niveau, @PathVariable long userId, Pageable pageable) {
        return service.findByNiveauAndUserId(Niveau.valueOf(niveau),userId, pageable);
    }
	
	@GetMapping("user/{userId}")
	// localhost:8080/passages/user/1
	public Page<PassageDto> findByUserId(@PathVariable long userId, Pageable pageable) {
		return service.findByUserId(userId,pageable);
	}

}
