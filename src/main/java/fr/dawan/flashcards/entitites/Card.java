package fr.dawan.flashcards.entitites;

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
    private String answer;

}
