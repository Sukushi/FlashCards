package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.card.Card;
import fr.dawan.flashcards.business.generic.BaseEntity;
import fr.dawan.flashcards.business.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Entity
@Table(name="passage")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Passage extends BaseEntity {

    /**
     * L'Objet Passage : Représentation de la relation entre User et Card avec en plus en paramètres
     * un Niveau et une date de dernière mise à jour.\n
     *
     * La Table passage : Table de jointure de la relation @ManyToMany UserCard
     *
     * 1 User à plusieurs Card - L'objet User aura une List<Card> : Toutes les cartes d'un seul User
     * 1 Card à plusieurs User - L'objet Card aura une List<User> : Tous les utilisateurs qui ont choisi d'ajouter cette carte
     *
     * Star UML : Diagramme de classe --- Aussi possible de passer par DBeaver → ER Diagram
     * Partie Associations/Relations (les revoir)
     */

    @ManyToOne
    private Card card;
    private Niveau niveau;

    private LocalDate dateUpdate;

    @ManyToOne
    private User user;


    public boolean isDaily() {
        return LocalDate.now().compareTo(dateUpdate) >= niveau.getDuree();
    }
    public Passage setToday(){
        return this.setDateUpdate(LocalDate.now());
    }
}
