package fr.dawan.flashcards.business.user;

import fr.dawan.flashcards.business.generic.GenericMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends GenericMapper<User, UserDto> {
	
	@Override
	UserDto toDto(User entity);
	
	@Override
	@InheritInverseConfiguration
	User toEntity(UserDto dto);
	
	UserLoginDto toLoginDto(User entity);
}
