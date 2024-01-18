package fr.dawan.flashcards.business.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private long id;
    private long version;
    private String categoryName;
    private String question;
    private String answer;
}
