package fr.dawan.flashcards;

import fr.dawan.flashcards.csv.CSVFlashCard;
import fr.dawan.flashcards.models.Niveau;
import fr.dawan.flashcards.models.Tiroir;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class FlashCardsApplication {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalDate old = LocalDate.of(2023,12,8);
		System.out.println(old.datesUntil(date).count());

		System.out.println(Arrays.toString(Niveau.values()));

		Niveau niveau = Niveau.NIVEAU3;
		System.out.println(niveau.ordinal()); // index de l'énumération (niveau -1)


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
