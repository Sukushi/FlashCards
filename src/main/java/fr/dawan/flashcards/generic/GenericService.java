package fr.dawan.flashcards.generic;

import fr.dawan.flashcards.generic.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericService<E extends BaseEntity> {
	
	Page<E> findAll(Pageable pageable); // Tous les enregistrements avec pagination
	Optional<E> findById(long id);
	E saveOrUpdate(E entity);
	void deleteById(long id);
	
}
