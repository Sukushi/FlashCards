package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.BaseEntity;
import fr.dawan.flashcards.business.entitites.Category;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Card extends BaseEntity {

	// this is a webhook
    private String title;
    private Category category;
    private String question;
    private String answer;

}
