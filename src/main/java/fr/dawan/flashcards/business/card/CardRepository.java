package fr.dawan.flashcards.business.card;

import fr.dawan.flashcards.business.entitites.Niveau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card,Long> {
	// Lister ici toutes les fonctions à implémenter aux cartes
	Page<Card> findById(long id, Pageable pageable);
	Page<Card> findByTitle(String title, Pageable pageable);
	/*Page<Card> findByCategory(String category, Pageable pageable);
	Page<Card> findByKeywords(String word, Pageable pageable);
	Page<Card> findByNiveau(Niveau niveau, Pageable pageable);*/

	// Déclarer les signatures des méthodes d'import / export
	// From CSV
	//Page<Card> importCSV(List<Card> cartes);
	// To CSV

}
