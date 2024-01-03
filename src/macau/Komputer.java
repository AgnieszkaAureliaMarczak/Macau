package macau;

public class Komputer extends Player {

    public Komputer(int indeks) {
        super(indeks);
    }

    @Override
    public Card selectCardToPlay(Card topCardOnDiscardPile) {
        return getCardToPlay(topCardOnDiscardPile);
    }
}
