package fr.dawan.flashcards.business.card;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
	// Lister ici toutes les fonctions à implémenter aux cartes
	Page<Card> findById(long id, Pageable pageable);
	Page<Card> findByTitle(String title, Pageable pageable);
	/*Page<Card> findByCategory(String category, Pageable pageable);
	Page<Card> findByKeywords(String word, Pageable pageable);
	Page<Card> findByNiveau(Niveau niveau, Pageable pageable);*/
}
