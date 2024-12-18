package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.card.CardDto;
import fr.dawan.flashcards.business.generic.BaseEntityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class PassageDto extends BaseEntityDto {
    private CardDto card;
    private Niveau niveau;
	private int duree;
	private LocalDate dateUpdate;
    private long userId;
}
