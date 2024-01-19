package fr.dawan.flashcards.business.user;

import fr.dawan.flashcards.business.generic.GenericServiceMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceMapper extends GenericServiceMapper<User,UserRepository> {
	
	public UserServiceMapper(UserRepository repository) {
		super(repository);
	}
	
}
