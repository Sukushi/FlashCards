package fr.dawan.flashcards.business.generic;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BaseEntityDto {
	protected long id;
	protected int version;
}
