package macau;

public enum Suit {
    DIAMOND, HEART, SPADE, CLUB;

     Suit() {

    }

    public String toString() {
        return name().substring(0,1)+ name().substring(1).toLowerCase();
    }
}
