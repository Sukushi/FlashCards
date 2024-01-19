package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.generic.GenericServiceBDD;
import fr.dawan.flashcards.business.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

	}

	@Override
	public void resetNiveau(long passageId) {

	}

	@Override
	public void setToday(long passageId) {

	}
}
