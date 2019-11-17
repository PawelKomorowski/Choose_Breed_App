package chooseBreed.backend.db.model.enums;

public enum TrainDifficulty {
    LATWO("Łatwo"),
    SREDNIO("Średnio"),
    TRUDNO("Trudno");

    String difficulty;

    TrainDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
