package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.GenericMapper;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardMapper extends GenericMapper<Card,CardDto> {

	
}
