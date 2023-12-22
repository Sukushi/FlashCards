package fr.dawan.flashcards.business.user;

import fr.dawan.flashcards.business.passage.Passage;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    // TODO Do I really need this  ? Ask Yannis Need Annotations in Dtos
    private List<Passage> tiroir;
}
