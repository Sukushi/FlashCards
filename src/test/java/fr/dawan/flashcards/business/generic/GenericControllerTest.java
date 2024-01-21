package fr.dawan.flashcards.business.generic;

import fr.dawan.flashcards.business.card.CardRepository;
import fr.dawan.flashcards.business.card.CardService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenericControllerTest {
    private CardService service = mock(CardService.class);

    private GenericController controller;

    Pageable pageable;


    @BeforeEach
    void setUp() {
        controller = mock(GenericController.class, withSettings().useConstructor(/* D ou DTO ? */,service).defaultAnswer(CALLS_REAL_METHODS));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void deleteById() {
    }
}