package fr.dawan.flashcards.business.passage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassageDto {
    private long id;
    private long version;
    private long cardId;
    private Niveau niveau;
    private LocalDate dateUpdate;
    private long userId;
}
