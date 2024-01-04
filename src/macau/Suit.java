package macau;

public enum Suit {
    DIAMOND("Karo"),
    HEART("Kier"),
    SPADE("Trefl"),
    CLUB("Pik");

    private String displayedName;

    Suit(String displayedName) {
        this.displayedName = displayedName;
    }

    public String toString() {
        return displayedName;
    }
}
