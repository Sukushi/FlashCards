package fr.dawan.flashcards.business.generic;

import fr.dawan.flashcards.business.card.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenericServiceMapperTest {

    private CardRepository repo = mock(CardRepository.class); // Je mock le repo

    private GenericServiceMapper serviceMapper ;

    @BeforeEach
    void setUp() {
        serviceMapper = mock(GenericServiceMapper.class, withSettings().useConstructor(repo).defaultAnswer(CALLS_REAL_METHODS));
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    @DisplayName("getEntity()")
    void getEntity() throws Exception {

        //ARRANGE
        long id = 1;
        Card card = new Card("Dependance", Category.JAVA,"Qu'est qu'une dépendance ?","Une dépendance c'est...");
        CardDto dto = new CardDto(id,0,"dependance",Category.JAVA,"Qu'est qu'une dépendance ?","Une dépendance c'est...");



        //ACT
        when(repo.findById(1L)).thenReturn(Optional.of(card));

       // E result = serviceMapper.getEntity(id);


    }
}