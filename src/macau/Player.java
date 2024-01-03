package macau;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Card> cards = new ArrayList<>();
    private int index;
    
    public Player(int index) {
        this.index = index;
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getNumberOfCardsInHand() {
        return cards.size();
    }

    public void printPlayersCards() {
        System.out.println("Twoje karty:");
        for (int i = 0; i < getNumberOfCardsInHand(); i++) {
            System.out.println((i + 1) + ": " + cards.get(i));
        }
    }

    public boolean canYouPlayCard(Card topCardOnDiscardPile) {
        Card cardToPlay = getCardToPlay(topCardOnDiscardPile);
        return cardToPlay != null;
    }

    Card getCardToPlay(Card topCardOnDiscardPile) {
        for (Card playersCard : cards) {
            if (playersCard.getKolor() == topCardOnDiscardPile.getKolor() ||
                    playersCard.getNumerycznaWartosc() == topCardOnDiscardPile.getNumerycznaWartosc()) {
                return playersCard;
            }
        }
        return null;
    }

    public Card selectCardToPlay(Card topCardOnDiscardPile) {
        System.out.println("Gracz robi ruch.");
        return null;
    }

    @Override
    public String toString() {
        return "Gracz nr " + (index + 1);
    }
}
