package chooseBreed.backend.db.model.enums;

public enum HairLength {
    KROTKA("krótka"),
    SREDNIA("średnia"),
    DLUGA("długa");

    String length;

    HairLength(String length) {
        this.length = length;
    }

    public String getLength() {
        return length;
    }
}
