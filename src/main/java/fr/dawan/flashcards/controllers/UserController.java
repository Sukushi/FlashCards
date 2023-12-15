package fr.dawan.flashcards.controllers;

import fr.dawan.flashcards.entitites.User;
import fr.dawan.flashcards.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
// localhost:8080/users -> display user's table
// localhost:8080/users/{id} -> display user's information from user.id = id
public class UserController {

    private final UserService service;

    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable long id) {
        return service.getById(id);
    }

}
