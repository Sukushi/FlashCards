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
public class Tiroir implements Serializable {

    private List<Compartiment> compartiments;

}
