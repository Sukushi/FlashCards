package fr.dawan.flashcards.user;


import fr.dawan.flashcards.generic.GenericController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController extends GenericController<User, UserService> {
	
	public UserController(UserService service) {
		super(service);
	}
	
	@GetMapping
    public Page<User> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
	
}
