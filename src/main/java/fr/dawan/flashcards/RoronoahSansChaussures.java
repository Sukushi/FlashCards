package fr.dawan.flashcards;

import fr.dawan.flashcards.business.csv.CSVFlashCard;
import fr.dawan.flashcards.business.entitites.Niveau;
import fr.dawan.flashcards.business.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

//@SpringBootApplication
@Slf4j
public class RoronoahSansChaussures {
    public static void main(String[] args) {
        SpringApplication.run(FlashCardsApplication.class, args);

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

        // Data for Roro
        String name = "Roro";
        String password = "Rorospassword";
        String email = "Roro@email.com";
        User user = new User(name,password,email);;
        //List<Card> list = user.getTiroir().stream().filter(passage -> passage.getNiveau() == Niveau.NIVEAU2).map(Passage::getCard).toList();// récupère que les card de niveau 2
        //List<Card> list1 = user.getTiroir().stream().filter(Passage::isDaily).map(Passage::getCard).toList(); // récupère les daily

        System.out.println("--- toString ---");
        System.out.println(date.toString());

        System.out.println("--- import export ---");
        try {
            System.out.println("- import -");
            CSVFlashCard csv = new CSVFlashCard();
            User userImport = csv.importCommode(user);
            System.out.println(userImport);

            System.out.println("- export -");
            csv.exportCommode(userImport);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


		/* System.out.println("---");
		CSVFlashCard csv = new CSVFlashCard();
		try {
			Tiroir tiroir = csv.importCommode();
			System.out.println(tiroir);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}*/


    }
}
