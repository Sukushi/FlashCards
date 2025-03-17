package fr.dawan.flashcards.business.passage;

import fr.dawan.flashcards.business.card.Card;
import fr.dawan.flashcards.business.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PassageTest {
	
	private Niveau niveau;
	private Passage passage;
	
	@BeforeEach
	void setUp() {
		niveau = Niveau.NIVEAU2;
		passage = new Passage(
				new Card(), niveau, LocalDate.now(), new User()
		);
	}
	
	@Test
	@DisplayName("isDaily() date = durée niveau")
	void isDailyEquivalentLevelDay_test() {
		passage.setDateUpdate(LocalDate.now().minusDays(niveau.getDuree()));
		assertTrue(passage.isDaily());
	}
	
	@Test
	@DisplayName("isDaily() date > durée niveau")
	void isDailySuperiorLevelDay_test() {
		passage.setDateUpdate(LocalDate.now().minusDays(niveau.getDuree()+1));
		assertTrue(passage.isDaily());
	}
	
	@Test
	@DisplayName("isDaily() date < durée niveau")
	void isDailyInferiorLevelDay_test() {
		passage.setDateUpdate(LocalDate.now().minusDays(niveau.getDuree()-1));
		assertFalse(passage.isDaily());
	}
}