package fr.dawan.flashcards.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private long id;
    private int version;
    private String categoryName;
    private String question;
    private String reponse;
}
