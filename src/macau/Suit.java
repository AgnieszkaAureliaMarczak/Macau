package macau;

public enum Suit {
    DIAMONDS("Karo"),
    HEARTS("Kier"),
    SPADES("Trefl"),
    CLUBS("Pik");

    private String displayedName;

    Suit(String displayedName) {
        this.displayedName = displayedName;
    }

    public String toString() {
        return displayedName;
    }
}
