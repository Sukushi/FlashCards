package fr.dawan.flashcards.user;

import fr.dawan.flashcards.generic.GenericServiceBDD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceBDD extends GenericServiceBDD<User,UserRepository> implements UserService {
	
	public UserServiceBDD(UserRepository repository) {
		super(repository);
	}

}
