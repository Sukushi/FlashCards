package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.GenericControllerMVC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cards")
public class CardControllerMVC extends GenericControllerMVC<CardDto, CardService> {
    public CardControllerMVC(CardService service) {
        super("cards",service);
    }

    @Override // Do I really need this ? TODO
    public String findById(long id, Model model) {
        return super.findById(id, model);
    }

//    @PostMapping("addAnnexe/{dossierId}")
//    public String addAnnexe(@PathVariable long dossierId, @RequestParam MultipartFile file){
//        service.addAnnexe(dossierId,file);
//        return "redirect:/dossiers/" + dossierId;
//    }
    @Override
    protected CardDto getDTO() {
        return new CardDto();
    }
}
