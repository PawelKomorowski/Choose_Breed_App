package chooseBreed.backend.db.model.enums;

public enum HairType {
    GLADKA("gładka"),
    FALISTA("falista"),
    PUCHATA("puchata"),
    SZORSTKA("szorstka");

    private String type;

    HairType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
