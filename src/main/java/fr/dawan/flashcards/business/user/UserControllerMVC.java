package fr.dawan.flashcards.business.user;

import fr.dawan.flashcards.business.generic.GenericControllerMVC;
import fr.dawan.flashcards.business.passage.PassageDto;
import fr.dawan.flashcards.business.passage.PassageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserControllerMVC extends GenericControllerMVC<UserDto, UserService> {
    public UserControllerMVC(UserService service) {
        super("users",service);
    }

    @Override
    protected UserDto getDTO() {
        return new UserDto();
    }
}
