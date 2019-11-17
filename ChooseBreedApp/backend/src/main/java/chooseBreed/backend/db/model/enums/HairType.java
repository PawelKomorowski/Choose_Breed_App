package chooseBreed.backend.db.model.enums;

public enum HairType {
    GLADKA("Gładka"),
    FALISTA("Falista"),
    PUCHATA("Puchata"),
    SZORSTKA("Szorstka");

    private String type;

    HairType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
