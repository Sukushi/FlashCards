package fr.dawan.flashcards.business.generic;

import fr.dawan.flashcards.business.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class GenericServiceMapper<E extends BaseEntity, R extends JpaRepository<E, Long>> {
	
	protected final R repository;
	
	// méthode pour le mapping
	public E getMapping(long userId) throws Exception {
		Optional<E> entity = repository.findById(userId);
		if (entity.isPresent()) {
			return entity.get();
		}
		throw new Exception();
	}
	
}
