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
    @OneToMany(mappedBy = "user")
    private List<Passage> tiroir;

}
