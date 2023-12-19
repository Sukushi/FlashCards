package fr.dawan.flashcards.generic;

import fr.dawan.flashcards.generic.BaseEntity;
import fr.dawan.flashcards.generic.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class GenericServiceBDD
	<E extends BaseEntity, R extends JpaRepository<E,Long>>
	implements GenericService<E> {
	
	
	protected final R repository;
	
	@Override
	public Page<E> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@Override
	public Optional<E> findById(long id) {
		return repository.findById(id);
	}
	
	@Override
	public E saveOrUpdate(E entity) {
		return repository.save(entity);
	}
	
	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}
}
