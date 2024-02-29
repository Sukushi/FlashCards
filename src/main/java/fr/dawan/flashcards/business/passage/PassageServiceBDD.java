package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.card.CardDto;
import fr.dawan.flashcards.business.generic.GenericServiceBDD;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class PassageServiceBDD extends GenericServiceBDD<Passage,PassageRepository,PassageDto,PassageMapper> implements PassageService {
	
	Random random = new Random();
	
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
	
	// elle nous sert pour le dev pour remplir notre BDD mais devra être supprimé en prod
	@Override
	public PassageDto insertPassage(long userId, long cardId) {
		CardDto cardDto = new CardDto();
		cardDto.setId(cardId);
		PassageDto dto = new PassageDto(0, 0, /*cardId,*/ cardDto, Niveau.NIVEAU1, Niveau.NIVEAU1.getDuree(), LocalDate.of(2024,1,1), userId);
		Passage entity = mapper.toEntity(dto);
		Passage saved = repository.save(entity);
		return mapper.toDto(saved);
	}

	@Override
	public void upNiveau(long passageId) {
		Passage passage = repository.findById(passageId).get();
		// Prochain Niveau // Contrôler que ce n'est pas le dernier niveau :
		int nextNiveau = passage.getNiveau().ordinal() + 1;
		if (nextNiveau < Niveau.values().length){
			passage.setNiveau(Niveau.values()[nextNiveau]);
		}
		passage.setToday();
		repository.save(passage);
	}

	@Override
	public void resetNiveau(long passageId) {
		Passage passage = repository.findById(passageId).get();
		passage.setNiveau(Niveau.NIVEAU1).setToday();
		repository.save(passage);
	}
	
	@Override
	public List<PassageDto> getDailyAll(long userId) {
		return repository.findByUserId(userId, Pageable.unpaged()).filter(Passage::isDaily).map(mapper::toDto).toList();
	}
	
	@Override
	public PassageDto getDaily(long userId) {
		List<PassageDto> dailyAll = getDailyAll(userId);
		return dailyAll.get(random.nextInt(dailyAll.size()));
	}

	// TODO : Améliorer encore la compréhension et l'assimilation de ci-dessus

}
