package macau;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getNumericValue() {
        return rank.getNumericValue();
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return suit + ", " + rank;
    }
}
