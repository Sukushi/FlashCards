package fr.dawan.flashcards.models;

public enum Niveau {
    NIVEAU1(1),
    NIVEAU2(3),
    NIVEAU3(7),
    NIVEAU4(14),
    NIVEAU5(21),
    NIVEAU6(30),
    NIVEAU7(90);

    private int niveau;

    Niveau(int niveau) {
        this.niveau = niveau;
    }

    public int getDuree() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
}