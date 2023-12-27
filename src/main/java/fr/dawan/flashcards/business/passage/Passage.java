package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.card.Card;
import fr.dawan.flashcards.business.generic.BaseEntity;
import fr.dawan.flashcards.business.user.User;
import fr.dawan.flashcards.business.entitites.Niveau;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
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
