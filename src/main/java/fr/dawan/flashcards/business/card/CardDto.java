package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.BaseEntityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class CardDto extends BaseEntityDto {
	private String title;
    private Category category;
    private String question;
    private String answer;
}
