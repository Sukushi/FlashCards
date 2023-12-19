package fr.dawan.flashcards.user;

import fr.dawan.flashcards.generic.BaseEntity;
import fr.dawan.flashcards.passage.Passage;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class User extends BaseEntity {

    private String name;
    private String code; // spring security à implémenter
    @OneToMany(mappedBy = "user")
    private List<Passage> tiroir;

}
