package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.generic.GenericControllerMVC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/passages")
public class PassageControllerMVC extends GenericControllerMVC<PassageDto, PassageService> {
    public PassageControllerMVC(PassageService service) {
        super("passages",service);
    }

    @Override
    protected PassageDto getDTO() {
        return new PassageDto();
    }
}
