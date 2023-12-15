package fr.dawan.flashcards.entitites;

import jakarta.persistence.Entity;
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
    private List<Passage> tiroir;

}
