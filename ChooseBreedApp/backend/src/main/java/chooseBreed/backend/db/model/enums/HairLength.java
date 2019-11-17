package chooseBreed.backend.db.model.enums;

public enum HairLength {
    KROTKA("Krótka"),
    SREDNIA("Średnia"),
    DLUGA("Długa");

    String length;

    HairLength(String length) {
        this.length = length;
    }

    public String getLength() {
        return length;
    }
}
