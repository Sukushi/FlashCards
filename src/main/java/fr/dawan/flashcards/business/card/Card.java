package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.BaseEntity;
import jakarta.persistence.Column;
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
    private String title;
    private Category category;
    private String question;

    @Column(columnDefinition="Text")
    private String answer;
}
