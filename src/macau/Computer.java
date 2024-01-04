package macau;

public class Computer extends Player {

    public Computer(int index) {
        super(index);
    }

    @Override
    public Card selectCardToPlay(Card topCardOnDiscardPile) {
        return getCardToPlay(topCardOnDiscardPile);
    }
}
