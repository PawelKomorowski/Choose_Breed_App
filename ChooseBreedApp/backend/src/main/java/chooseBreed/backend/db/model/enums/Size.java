package chooseBreed.backend.db.model.enums;

public enum Size {
    MALY("Mały"),
    SREDNI("Średni"),
    DUZY("Duży"),
    OLBRZYM("Olbrzym");

    private String size;

    Size(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
