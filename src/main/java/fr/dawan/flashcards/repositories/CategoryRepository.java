package fr.dawan.flashcards.repositories;

import fr.dawan.flashcards.entitites.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
