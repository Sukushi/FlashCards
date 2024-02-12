package fr.dawan.flashcards.business.generic;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
public abstract class GenericControllerMVC<D,S extends GenericService<D>> {
    protected final String path;
    protected final S service;


    @GetMapping
    public String all(Model model) {
        // Model permet la transmission d'informations entre le programme et le template
        model.addAttribute("elements", service.findAll(Pageable.unpaged()));
        return path + "/all";
    }

    @GetMapping("{id}")
    public String findById(@PathVariable long id, Model model) {
        // Model permet la transmission d'informations entre le programme et le template
        model.addAttribute("element", service.findById(id).orElse(null));
        return path + "/byId";
    }

    // SAVE OR UPDATE : next level donc HTTP : POST

    /**
     * Je sélectionne l'attribut "element" de mon Model
     * On le stocke dans le paramètre dto
     *
     * INSERTION ou MODIFICATION
     * Jpa regarde l'ID
     *
     * @param dto
     * @return
     */
    @PostMapping
    public String saveOrUpdate(@ModelAttribute("element") D dto){
        service.saveOrUpdate(dto);
        return "redirect:/"+path;
    }

    @GetMapping("/remove/{id}")
    public String delete(@PathVariable long id) {
        service.deleteById(id);
        return "redirect:/" + path;
    }

    @ModelAttribute("path") // Sur un getter
    public String getPath() {
        return path;
    }

    protected abstract D getDTO(); // Méthode abstraite qui force les classes (filles) à fournir le code nécessaire
}
