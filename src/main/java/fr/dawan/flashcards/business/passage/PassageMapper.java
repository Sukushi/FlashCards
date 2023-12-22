package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PassageMapper extends GenericMapper<Passage, PassageDto> {

}
