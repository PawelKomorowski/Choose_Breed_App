package chooseBreed.backend.db.model.enums;

public enum IllnessPossibility {
    MALA("Mała"),
    SREDNIA("Średnia"),
    DUZA("Duża");

    String illness;

    IllnessPossibility(String illness) {
        this.illness = illness;
    }

    public String getIllness() {
        return illness;
    }
}
