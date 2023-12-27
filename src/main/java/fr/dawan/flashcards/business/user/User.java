package fr.dawan.flashcards.business.user;

import fr.dawan.flashcards.business.generic.BaseEntity;
import fr.dawan.flashcards.business.passage.Passage;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User extends BaseEntity {

    private String name;
    private String code; // spring security à implémenter
    @OneToMany(mappedBy = "user")
	@ToString.Exclude
	private List<Passage> tiroir;

}
