package fr.dawan.flashcards.models;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class User extends BaseEntity implements Serializable {

    private String name;
    private String code; // spring security à implémenter
    private List<Passage> tiroir;

}
