package fr.dawan.flashcards.business.csv;

import fr.dawan.flashcards.business.card.Card;
import fr.dawan.flashcards.business.entitites.Category;
import fr.dawan.flashcards.business.entitites.Niveau;
import fr.dawan.flashcards.business.passage.Passage;
import fr.dawan.flashcards.business.user.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVFlashCard {

	private static String FILENAME = "commode.csv";
	private static final String DELIMITER = ";";
	private static final String DATE_DELIMITER = "-";

	public User importCommode() throws IOException{
		User user = new User("localName","localPassword",new ArrayList<>(),"localEmail");

		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			br.lines().forEach( line -> {
				String[] values = line.split(DELIMITER);

				Niveau niveau = Niveau.valueOf(values[0]);
				List<Integer> dateInfo = Arrays.stream(values[1].split(DATE_DELIMITER)).map(Integer::valueOf).toList();
				LocalDate date = LocalDate.of(dateInfo.get(0),dateInfo.get(1),dateInfo.get(2));
				Category category = Category.valueOf(values[2]);
				String title = values[3], question = values[4], answer = values[5];

				Card card = new Card(title, category, question, answer);
				Passage passage = new Passage(card,niveau,date,user);
				user.getTiroir().add(passage);
			});
		}

		return user;
	}

	public void exportCommode(User user) {
		try (FileWriter fw = new FileWriter(FILENAME)) {
			user.getTiroir().forEach(passage -> {
				try {
					appendPassage(passage,fw);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void appendPassage(Passage passage, FileWriter fw) throws IOException {
		Card card = passage.getCard();
		fw.append(passage.getNiveau().name());
		fw.append(DELIMITER);
		fw.append(passage.getDateUpdate().toString());
		fw.append(DELIMITER);
		fw.append(card.getCategory().name());
		fw.append(DELIMITER);
		fw.append(card.getTitle());
		fw.append(DELIMITER);
		fw.append(card.getQuestion());
		fw.append(DELIMITER);
		fw.append(card.getAnswer());
		fw.append("\n");
	}
	
}
