package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.card.CardServiceMapper;
import fr.dawan.flashcards.business.generic.GenericMapper;
import fr.dawan.flashcards.business.user.UserServiceMapper;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserServiceMapper.class, CardServiceMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PassageMapper extends GenericMapper<Passage, PassageDto> {
    @Override
    @Mapping(source = "user.id", target = "userId")
    /*@Mapping(source = "card.id", target = "cardId")*/
    PassageDto toDto(Passage entity);
	
	@Override
	@InheritInverseConfiguration
	Passage toEntity(PassageDto dto);
	
}
