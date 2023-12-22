package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardMapper extends GenericMapper<Card,CardDto> {
}
