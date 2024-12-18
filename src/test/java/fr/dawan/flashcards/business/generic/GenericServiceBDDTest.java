package fr.dawan.flashcards.business.generic;

import fr.dawan.flashcards.business.card.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenericServiceBDDTest {
	
	private CardRepository repository = mock(CardRepository.class);
	private CardMapper mapper = mock(CardMapper.class);
	private GenericServiceBDD service;
	
	Pageable pageable;
	
	@BeforeEach
	void setUp() {
		service = mock(GenericServiceBDD.class, withSettings().useConstructor(repository,mapper).defaultAnswer(CALLS_REAL_METHODS));
		pageable = Pageable.unpaged();
	}
	
	@Test
	@DisplayName("findAll()")
	void findAll_test() {
		// Arrange
		Card card1 = new Card("Dependance", Category.JAVA,"Qu'est qu'une dépendance ?","Une dépendance c'est...");
		Card card2 = new Card("Implementation",Category.JAVA,"Qu'est qu'une implémentation ?","Une implémentation c'est...");
		Page<Card> entities = new PageImpl<>(List.of(card1,card2));
		
		CardDto dto1 = new CardDto(0L,0,"dependance",Category.JAVA,"Qu'est qu'une dépendance ?","Une dépendance c'est...");
		CardDto dto2 = new CardDto(0L,0,"implementation",Category.JAVA,"Qu'est qu'une implémentation ?","Une implémentation c'est...");
		List<CardDto> expected = List.of(dto1,dto2);
		
		// Act
		when(repository.findAll(pageable)).thenReturn(entities);
		when(mapper.toDto(card1)).thenReturn(dto1);
		when(mapper.toDto(card2)).thenReturn(dto2);
		
		Page result = service.findAll(pageable);
		
		// Assert
		assertTrue(result.getContent().containsAll(expected));
	}
	
	@Test
	@DisplayName("findById()")
	void findById_test() {
		long id = 1;
		Card card = new Card("Dependance", Category.JAVA,"Qu'est qu'une dépendance ?","Une dépendance c'est...");
		CardDto dto = new CardDto(id,0,"dependance",Category.JAVA,"Qu'est qu'une dépendance ?","Une dépendance c'est...");
		
		when(repository.findById(1L)).thenReturn(Optional.of(card));
		when(mapper.toDto(card)).thenReturn(dto);
		
		Optional result = service.findById(id);
		
		assertTrue(result.isPresent());
		assertInstanceOf(CardDto.class, result.get());
	}
	
	@Test
	@DisplayName("saveOrUpdate()")
	void saveOrUpdate_test() {
		Card card = new Card("Dependance", Category.JAVA,"Qu'est qu'une dépendance ?","Une dépendance c'est...");
		CardDto dto = new CardDto(1L,0,"dependance",Category.JAVA,"Qu'est qu'une dépendance ?","Une dépendance c'est...");
		
		when(repository.save(any())).thenReturn(card);
		when(mapper.toEntity(dto)).thenReturn(card);
		when(mapper.toDto(card)).thenReturn(dto);
		
		Object inserted = service.saveOrUpdate(dto);
		
		assertEquals(dto, inserted);
	}
	
	@Test
	@DisplayName("deleteById()")
	void deleteByID_test() {
		long id = 1L;
		doNothing().when(repository).deleteById(anyLong());
		
		service.deleteById(id);
		
		verify(repository, times(1)).deleteById(anyLong());
	}
}