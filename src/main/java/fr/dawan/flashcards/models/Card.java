package fr.dawan.flashcards.models;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Card implements Serializable {

    private String question;
    private String answer;
    private LocalDate date;

}
