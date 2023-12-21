package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.generic.GenericServiceBDD;
import fr.dawan.flashcards.business.entitites.Niveau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PassageServiceBDD extends GenericServiceBDD<Passage,PassageRepository> implements PassageService {
	
	public PassageServiceBDD(PassageRepository repository) {
		super(repository);
	}
	
	
	@Override
	public Page<Passage> findByNiveauAndUserId(Niveau niveau, long userId, Pageable pageable) {
		return repository.findByNiveauAndUserId(niveau,userId,pageable);
	}
	
	@Override
	public Page<Passage> findByUserId(long userId, Pageable pageable) {
		return repository.findByUserId(userId,pageable);
	}
}
