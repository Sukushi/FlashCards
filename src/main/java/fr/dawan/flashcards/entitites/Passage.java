package fr.dawan.flashcards.entitites;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
