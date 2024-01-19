package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.generic.GenericMapper;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardMapper extends GenericMapper<Card,CardDto> {
    @Override
    @Mapping(source = "category", target = "categoryName", qualifiedByName = "getCategory")
    CardDto toDto(Card entity);
	
	@Override
	@InheritInverseConfiguration
	Card toEntity(CardDto dto);

    @Named("getCategory")
    default String categoryConverter (Category category) {
        return category.name();
    }
	@Named("getCategory")
	default Category categoryConverter(String category) {
		return Category.valueOf(category);
	}
}
