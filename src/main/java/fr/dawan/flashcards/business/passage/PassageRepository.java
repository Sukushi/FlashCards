package fr.dawan.flashcards.business.passage;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassageRepository extends JpaRepository<Passage,Long> {

	Page<Passage> findByNiveauAndUserId(Niveau niveau, long userId, Pageable pageable);
	Page<Passage> findByUserId(long userId, Pageable pageable);
	// Page<Passage> createTiroir(long userId);
}
