package fr.dawan.flashcards.business.user;

import fr.dawan.flashcards.business.generic.GenericMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends GenericMapper<User, UserDto> {
	
	@Override
	UserDto toDto(User entity);
	
	@Override
	@InheritInverseConfiguration
	User toEntity(UserDto dto);
	
	UserLoginDto toLoginDto(User entity);
}
