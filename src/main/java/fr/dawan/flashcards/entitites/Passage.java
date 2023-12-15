package fr.dawan.flashcards.entitites;

import fr.dawan.flashcards.entitites.BaseEntity;
import fr.dawan.flashcards.entitites.Card;
import fr.dawan.flashcards.entitites.Niveau;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Passage extends BaseEntity {

    private Card card;
    private Niveau niveau;
    private LocalDate dateUpdate;

    public boolean isDaily() {
        return LocalDate.now().compareTo(dateUpdate) >= niveau.getDuree();
    }

}
