package fr.dawan.flashcards.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericService<D> {
    Page<D> findAll(Pageable pageable); // Tous les enregistrements avec pagination
    Optional<D> findById(long id);
    D saveOrUpdate(D entity);
    void deleteById(long id);
}
