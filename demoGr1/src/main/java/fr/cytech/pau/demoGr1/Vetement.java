package fr.cytech.pau.demoGr1;

public enum Vetement {
    CHEMISE("Chemise"),
    PANTALON("Pantalon"),
    JUPE("Jupe"),
    TSHIRT("T-shirt"),
    VESTE("Veste"),
    ROBE("Robe");

    private String description;

    Vetement(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}