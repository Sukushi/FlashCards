package fr.dawan.flashcards.business.card;

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

    }

    @Test
    void getCategory() {
    }

    @Test
    void getQuestion() {
    }

    @Test
    void getAnswer() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void setCategory() {
    }

    @Test
    void setQuestion() {
    }

    @Test
    void setAnswer() {
    }

    @Test
    void testToString() {
    }
}