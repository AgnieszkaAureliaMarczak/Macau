package macau;

public enum Rank {
    TWO(2, "Dwa"),
    THREE(3, "Trzy"),
    FOUR(4, "Cztery"),
    FIVE(5, "Pięć"),
    SIX(6, "Sześć"),
    SEVEN(7, "Siedem"),
    EIGHT(8, "Osiem"),
    NINE(9, "Dziewięć"),
    TEN(10, "Dziesięć"),
    JACK(11, "Walet"),
    QUEEN(12, "Dama"),
    KING(13, "Król"),
    ACE(14, "As");

    private int numericValue;
    private String displayedName;

    Rank(int numericValue, String displayedName) {
        this.numericValue = numericValue;
        this.displayedName = displayedName;
    }

    public int getNumericValue() {
        return numericValue;
    }

    @Override
    public String toString() {
        return displayedName;
    }
}
