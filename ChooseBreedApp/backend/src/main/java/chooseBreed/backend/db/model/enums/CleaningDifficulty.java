package chooseBreed.backend.db.model.enums;

public enum CleaningDifficulty {
    LATWO("łatwo"),
    SREDNIO("średnio"),
    TRUDNO("trudno");

    String difficulty;

    CleaningDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
