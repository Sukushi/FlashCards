package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.entitites.Category;
import fr.dawan.flashcards.business.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardMapper extends GenericMapper<Card,CardDto> {
    @Override
    @Mapping(source = "category", target = "categoryName", qualifiedByName = "getCategory")
    CardDto toDto(Card entity);

    @Named("getCategory")
    default String categoryConverter (Category category) {
        return category.name();
    }
}
