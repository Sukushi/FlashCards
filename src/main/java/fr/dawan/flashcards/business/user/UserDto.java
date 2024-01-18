package fr.dawan.flashcards.business.user;

import fr.dawan.flashcards.business.passage.PassageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private long version;
    private String name;
    private List<PassageDto> tiroir;
}
