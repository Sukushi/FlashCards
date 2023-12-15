package fr.dawan.flashcards.csv;

import fr.dawan.flashcards.models.Card;
import fr.dawan.flashcards.models.Niveau;
import fr.dawan.flashcards.models.Tiroir;

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

    public Tiroir importCommode() throws IOException{
        Tiroir tiroir = new Tiroir();

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            br.lines().forEach( line -> {
                String[] values = line.split(DELIMITER);

                Niveau niveau = Niveau.valueOf(values[0]);
                List<Integer> dateInfo = Arrays.stream(values[1].split(DATE_DELIMITER)).map(Integer::valueOf).toList();
                LocalDate date = LocalDate.of(dateInfo.get(0),dateInfo.get(1),dateInfo.get(2));
                String question = values[2], answer = values[3];

                //tiroir.getCompartiments().get(niveau.ordinal()).addCard(new Card(question,answer,date));
            });
        }

        return tiroir;
    }

    public void exportCommode(Tiroir tiroir) {
        try (FileWriter fw = new FileWriter(FILENAME)) {

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
