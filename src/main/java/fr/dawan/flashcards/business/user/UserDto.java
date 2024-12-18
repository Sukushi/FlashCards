package fr.dawan.flashcards.business.user;

import fr.dawan.flashcards.business.generic.BaseEntityDto;
import fr.dawan.flashcards.business.passage.PassageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseEntityDto {
    private String name;
    private List<PassageDto> tiroir;
}
