package fr.dawan.flashcards.models;

import fr.dawan.flashcards.entitites.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Passage extends BaseEntity implements Serializable {

    private Card card;
    private Niveau niveau;
    private LocalDate dateUpdate;

    public boolean isDaily() {
        return LocalDate.now().compareTo(dateUpdate) >= niveau.getDuree();
    }

}
