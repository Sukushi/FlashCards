package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.card.Card;
import fr.dawan.flashcards.business.generic.BaseEntity;
import fr.dawan.flashcards.business.user.User;
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
public class Passage extends BaseEntity {

    // TODO Romain

    /**
     * On est d'accord pour dire que Passage, à l'heure actuelle, est la table de jointure entre Card et User ?
     *
     * On est dans une relation 1 ou plusieurs passages correspond(ent) à Uniquement 1 User et à uniquement 1 Card
     *
     * Star UML : Diagramme de classe
     * Partie Associations/Relations (les revoir)
     *
     * Faire le DC de Flashcards
     *
     */

    @ManyToOne
    private Card card;
    private Niveau niveau;

    // Annotation ?? Embedded ?
    // TODO Initialiser dans le constructeur / les constructeurs
    private LocalDate dateUpdate;
    @ManyToOne
    private User user;

    /*
    On va pouvoir retrouver la date de création du passage via la BDD
     */

    public boolean isDaily() {
        return LocalDate.now().compareTo(dateUpdate) >= niveau.getDuree();
    }
    public Passage setToday(){
        return this.setDateUpdate(LocalDate.now());
    }
}
