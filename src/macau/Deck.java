package macau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards = new ArrayList<>();
    private List<Card> discardPile;

    public Deck(List<Card> discardPile) {
        this.discardPile = discardPile;
    }

    public List<Card> prepare() {
        shuffle(create());
        return cards;
    }

    private ArrayList<Card> create() {
        ArrayList<Card> deck = new ArrayList<>();
        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();
        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }

    private void shuffle(List<Card> deckToShuffle) {
        Random random = new Random();
        int deckSize = deckToShuffle.size();
        for (int i = 0; i < deckSize; i++) {
            int cardDrawn = random.nextInt(deckToShuffle.size());
            cards.add(deckToShuffle.remove(cardDrawn));
        }
    }

    public Card removeFirstCard() {
        if (cards.isEmpty()) {
            topUp();
        }
        return cards.remove(0);
    }

    private void topUp() {
        int discardPileSize = discardPile.size();
        List<Card> deckToShuffle = new ArrayList<>();
        for (int i = 1; i < discardPileSize; i++) {
            deckToShuffle.add(discardPile.remove(i));
        }
        shuffle(deckToShuffle);
        print();
    }

    private void print() {
        int index = 1;
        for (Card card : cards) {
            System.out.println(index + ": " + card);
            index++;
        }
    }
}
