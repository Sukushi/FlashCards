package fr.dawan.flashcards.business.passage;

import lombok.Getter;

@Getter
public enum Niveau {
    NIVEAU1(1),
    NIVEAU2(3),
    NIVEAU3(7),
    NIVEAU4(14),
    NIVEAU5(21),
    NIVEAU6(30),
    NIVEAU7(90);

    private final int duree;

    Niveau(int duree) {
        this.duree = duree;
    }

    public int getDuree() {
        return duree;
    }

}