package chooseBreed.backend.db.model.enums;

public enum TrainDifficulty {
    LATWO("łatwo"),
    SREDNIO("średnio"),
    TRUDNO("trudno");

    String difficulty;

    TrainDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
