package fr.dawan.flashcards.models;

import fr.dawan.flashcards.entitites.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Card extends BaseEntity implements Serializable {

    private String title;
    private Category category;
    private String question;
    private String answer;

}
