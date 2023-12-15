package fr.dawan.flashcards.models;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Compartiment implements Serializable {

    Niveau niveau;
    private List<Card> cards;

    public void addCard(Card card) {
        cards.add(card);
    }

}
