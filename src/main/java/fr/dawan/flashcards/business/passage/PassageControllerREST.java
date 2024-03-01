package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.generic.GenericControllerREST;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/passages")
public class PassageControllerREST extends GenericControllerREST<PassageDto, PassageService> {
	
	public PassageControllerREST(PassageService service) {
		super(service);
	}
	
	@Override
	@PostMapping
	public PassageDto saveOrUpdate(@RequestBody PassageDto dto) {
		return super.saveOrUpdate(dto.setDateUpdate(LocalDate.now()));
	}
	
	/*@GetMapping("/niveau/{niveau}/{userId}")
    *//* localhost:8080/passages/niveau/NIVEAU2/1 *//*
    public Page<PassageDto> findByNiveauAndUserId(@PathVariable String niveau, @PathVariable long userId, Pageable pageable) {
        return service.findByNiveauAndUserId(Niveau.valueOf(niveau),userId, pageable);
    }*/
	
	@GetMapping("user/{userId}")
	// localhost:8080/passages/user/1?niveau=1
	public Page<PassageDto> findByUserId(@PathVariable long userId, @RequestParam(defaultValue = "0") int niveau, Pageable pageable) {
		// permet de fusionner 'findByUserId' et 'findByNiveauAndUserId' avec un requestParam
		// permet de préciser ou non le niveau :
		// --> avec findByNiveauAndUserId : '.../niveau/niveau2/1'
		// --> avec findByUserId          : '.../user/1?niveau=2'
		if (niveau == 0) {
			return service.findByUserId(userId,pageable);
		} else {
			return service.findByNiveauAndUserId(Niveau.values()[niveau-1],userId, pageable);
		}
	}
	
	@GetMapping("daily/{userId}")
	public PassageDto getDaily(@PathVariable long userId) {
		return service.getDaily(userId);
	}
	
	@PutMapping("level/{passageId}")
	public void changeNiveau(@RequestParam(required = false) boolean success, @PathVariable long passageId) {
		if (success) {
			service.upNiveau(passageId);
		} else {
			service.resetNiveau(passageId);
		}
	}

}
