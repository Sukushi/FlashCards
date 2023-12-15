package fr.dawan.flashcards.controllers;

import fr.dawan.flashcards.entitites.Card;
import fr.dawan.flashcards.entitites.Passage;
import fr.dawan.flashcards.services.PassageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("passages")
// localhost:8080/users -> display user's table
// localhost:8080/users/{id} -> display user's information from user.id = id
public class PassageController {

    private final PassageService service;

    @GetMapping
    public List<Passage> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Passage getById(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping("/niveau/{niveau}/{userId}")
    // localhost:8080/passages/niveau/NIVEAU2/1
    public List<Card> findByNiveauAndUserId(@PathVariable String niveau, @PathVariable long userId) {
        return service.findByNiveauAndUserId(niveau,userId);
    }

}
