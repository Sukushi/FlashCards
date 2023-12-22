package fr.dawan.flashcards.business.csv;

import fr.dawan.flashcards.business.entitites.Category;
import fr.dawan.flashcards.business.entitites.Niveau;
import fr.dawan.flashcards.business.user.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CSVFlashCard {

    private static String FILENAME = "commode.fr.dawan.flashcards.csv";
    private static final String DELIMITER = ";";
    private static final String DATE_DELIMITER = ",";

    public User importCommode() throws IOException{
        User user = new User();

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            br.lines().forEach( line -> {
                String[] values = line.split(DELIMITER);

                Niveau niveau = Niveau.valueOf(values[0]);
                List<Integer> dateInfo = Arrays.stream(values[1].split(DATE_DELIMITER)).map(Integer::valueOf).toList();
                LocalDate date = LocalDate.of(dateInfo.get(0),dateInfo.get(1),dateInfo.get(2));
                Category category = Category.valueOf(values[2]);
                String name = values[3], question = values[4], answer = values[5];


            });
        }

        return user;
    }

    public void exportCommode(User user) {
        try (FileWriter fw = new FileWriter(FILENAME)) {

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
