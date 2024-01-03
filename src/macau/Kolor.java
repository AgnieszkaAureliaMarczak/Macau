package macau;

public enum Kolor {
    KARO, KIER, PIK, TREFL;

     Kolor() {

    }

    public String toString() {
        return name().substring(0,1)+ name().substring(1).toLowerCase();
    }
}
