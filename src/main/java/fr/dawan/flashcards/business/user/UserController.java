package fr.dawan.flashcards.business.user;


import fr.dawan.flashcards.business.generic.GenericController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends GenericController<UserDto, UserService> {
	
	public UserController(UserService service) {
		super(service);
	}
	
	@GetMapping
    public Page<UserDto> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
	
}
