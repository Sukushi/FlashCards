package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PassageMapper extends GenericMapper<Passage, PassageDto> {
    @Override
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "card.id", target = "cardId")
    PassageDto toDto(Passage entity);
}
