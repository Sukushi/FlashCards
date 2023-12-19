package fr.dawan.flashcards.passage;

import fr.dawan.flashcards.card.Card;
import fr.dawan.flashcards.generic.BaseEntity;
import fr.dawan.flashcards.entitites.Niveau;
import fr.dawan.flashcards.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Passage extends BaseEntity {

    @ManyToOne
    private Card card;
    private Niveau niveau;
    private LocalDate dateUpdate;
    @ManyToOne
    private User user;

    public boolean isDaily() {
        return LocalDate.now().compareTo(dateUpdate) >= niveau.getDuree();
    }

}
