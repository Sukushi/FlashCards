package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.card.CardDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PassageDto {
    private long id;
    private int version;
    /*private long cardId;*/
    private CardDto card; // pour utiliser le post mapping plus facilement
    private Niveau niveau;
	private int duree;
	private LocalDate dateUpdate;
    private long userId;
}
