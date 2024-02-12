package fr.dawan.flashcards.business.user;


import fr.dawan.flashcards.business.generic.GenericControllerREST;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserControllerREST extends GenericControllerREST<UserDto, UserService> {
	
	public UserControllerREST(UserService service) {
		super(service);
	}
	
}
