package fr.dawan.flashcards.generic;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@RequiredArgsConstructor
public abstract class GenericServiceBDD<
        E extends BaseEntity,
        R extends JpaRepository<E, Long>,
        D,
        M extends GenericMapper<E,D>
        > implements GenericService<D> {

    protected final R repository;
    protected final M mapper;
    @Override
    public Page<D> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }
    @Override
    public Optional<D> findById(long id) {
        return repository.findById(id).map(mapper::toDto);
    }
    @Override
    public D saveOrUpdate(D dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
