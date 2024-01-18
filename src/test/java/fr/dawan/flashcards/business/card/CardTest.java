package fr.dawan.flashcards.business.card;

import org.jacoco.agent.rt.internal_4a7f17c.IExceptionLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    Card card;
    Card cardTemoin;

    @BeforeEach
    void setUp() {
        System.out.println(">>>>>>>>> @BeforeEach");
        card = new Card();
        cardTemoin = new Card("temoin",Category.JAVA,"Question Témoin","Réponse Témoin");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTitle() {

        // AAA
        // Arrange
        // Act
        // Assert

        String obtenu = cardTemoin.getTitle(); // Act
        String attendu = "temoin";

        assertEquals(attendu,obtenu);
        System.out.printf("\ngetTitle : %s - %s",obtenu,attendu);
    }

    @Test
    void getCategory() {
        String expected = "JAVA";

        String actual = cardTemoin.getCategory().toString();

        assertEquals(expected,actual);
        System.out.printf("\ngetCategory : %s - %s",expected,actual);
    }


    @Test
    void getQuestion() {
        assertEquals("Question Témoin",cardTemoin.getQuestion());

        // Ces tests mon permis de pratiquer, ils étaient néanmoins <complètement> inutiles
    }
}