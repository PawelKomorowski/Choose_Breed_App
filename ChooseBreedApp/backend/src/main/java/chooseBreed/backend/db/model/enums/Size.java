package chooseBreed.backend.db.model.enums;

public enum Size {
    MALY("mały"),
    SREDNI("średni"),
    DUZY("duży"),
    OLBRZYM("olbrzym");

    private String size;

    Size(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
