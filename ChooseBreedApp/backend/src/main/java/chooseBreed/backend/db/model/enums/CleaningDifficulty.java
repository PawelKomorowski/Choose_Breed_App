package chooseBreed.backend.db.model.enums;

public enum CleaningDifficulty {
    LATWO("Łatwo"),
    SREDNIO("Średnio"),
    TRUDNO("Trudno");

    String difficulty;

    CleaningDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
