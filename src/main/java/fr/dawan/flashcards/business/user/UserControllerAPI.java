package fr.dawan.flashcards.business.user;


import fr.dawan.flashcards.business.generic.GenericControllerAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserControllerAPI extends GenericControllerAPI<UserDto, UserService> {
	
	public UserControllerAPI(UserService service) {
		super(service);
	}
	
}
