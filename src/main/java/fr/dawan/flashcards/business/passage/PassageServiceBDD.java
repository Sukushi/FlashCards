package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.generic.GenericServiceBDD;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PassageServiceBDD extends GenericServiceBDD<Passage,PassageRepository,PassageDto,PassageMapper> implements PassageService {
	
	public PassageServiceBDD(PassageRepository repository, PassageMapper mapper) {
		super(repository, mapper);
	}
	
	@Override
	public Page<PassageDto> findByNiveauAndUserId(Niveau niveau, long userId, Pageable pageable) {
		return repository.findByNiveauAndUserId(niveau,userId,pageable).map(mapper::toDto);
	}
	
	@Override
	public Page<PassageDto> findByUserId(long userId, Pageable pageable) {
		return repository.findByUserId(userId,pageable).map(mapper::toDto);
	}
}
