package fr.dawan.flashcards;

import fr.dawan.flashcards.entitites.Card;
import fr.dawan.flashcards.entitites.Niveau;
import fr.dawan.flashcards.entitites.Passage;
import fr.dawan.flashcards.entitites.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FlashCardsApplication {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalDate old = LocalDate.of(2023,12,8);
		System.out.println("--- dates until ---");
		System.out.println(old.datesUntil(date).toList());
		// System.out.println(date.datesUntil(old).count());
		System.out.println("--- compare to ---");
		System.out.println(date.compareTo(old));
		System.out.println(old.compareTo(date));

		System.out.println("--- array values : enum Niveau ---");
		System.out.println(Arrays.toString(Niveau.values()));

		System.out.println("--- index : enum Niveau ---");
		Niveau niveau = Niveau.NIVEAU3;
		System.out.println(niveau.ordinal()); // index de l'énumération

		System.out.println("--- tiroir ---");
		User user = new User();
		List<Card> list = user.getTiroir().stream()
				.filter(passage -> passage.getNiveau() == Niveau.NIVEAU2).map(Passage::getCard).toList();// récupère que les card de niveau 2
		List<Card> list1 = user.getTiroir().stream().filter(Passage::isDaily).map(Passage::getCard).toList(); // récupère les daily


		/*System.out.println("---");
		CSVFlashCard csv = new CSVFlashCard();
		try {
			Tiroir tiroir = csv.importCommode();
			System.out.println(tiroir);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}*/


	}

}
