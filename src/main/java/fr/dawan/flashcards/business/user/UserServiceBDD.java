package fr.dawan.flashcards.business.user;

import fr.dawan.flashcards.business.generic.GenericServiceBDD;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceBDD extends GenericServiceBDD<User,UserRepository,UserDto,UserMapper> implements UserService, UserDetailsService {
	
	public UserServiceBDD(UserRepository repository,UserMapper mapper) {
		super(repository, mapper);
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + " not found."));
	}
}
