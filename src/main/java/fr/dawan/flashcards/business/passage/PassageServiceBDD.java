package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.generic.GenericServiceBDD;
import fr.dawan.flashcards.business.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

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
	
	@Override
	public void insertPassage(long userId, long cardId) {
		PassageDto dto = new PassageDto(0, 0, cardId, Niveau.NIVEAU1, LocalDate.now(), userId);
		Passage entity = mapper.toEntity(dto);
		repository.save(entity);
	}

	@Override
	public void upNiveau(long passageId) {
		// Prochain Niveau // Contrôler que ce n'est pas le dernier niveau :
		int niveauActuel = repository.findById(passageId).get().getNiveau().ordinal();
		if (niveauActuel+1 < Niveau.values().length){
			Niveau niveauSouhaite = Niveau.values()[repository.findById(passageId).get().getNiveau().ordinal()+1];
			repository.findById(passageId).get().setNiveau(niveauSouhaite);
		}
	}

	@Override
	public void resetNiveau(long passageId) {
		repository.findById(passageId).get()
				.setNiveau(Niveau.NIVEAU1);
	}

	private Passage setToday(Passage passage){
        return passage.setDateUpdate(LocalDate.now());
    }

}
