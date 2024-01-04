package macau;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Card> discardPile = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private Deck deck = new Deck(discardPile);
    private int numberOfPlayers;

    public void play() {
        prepare();
        start();
    }

    private void prepare() {
        welcome();
        establishNumberOfPlayers();
        deck.prepare();
        dealCards();
        signalGameStart();
        drawFirstCard();
    }

    private void welcome() {
        System.out.println("Witaj w grze w makao!");
    }

    private void establishNumberOfPlayers() {
        boolean correctNumberOfPlayers;
        do {
            System.out.println("Podaj liczbę graczy (od 2 do 6).");
            numberOfPlayers = ReadingNumberFromConsole.readNumber();
            correctNumberOfPlayers = true;
            if (numberOfPlayers < 2 || numberOfPlayers > 6) {
                System.out.println("Podana liczba graczy wykracza poza zakres 2-6.");
                correctNumberOfPlayers = false;
            }
        } while (!correctNumberOfPlayers);
        players.add(new Human(0));
        for (int i = 1; i < numberOfPlayers; i++) {
            players.add(new Computer(i));
        }
        System.out.println("Jesteś graczem nr 1.");
    }

    private void dealCards() {
        for (int i = 0; i < 5; i++) {
            for (Player player : players) {
                player.receiveCard(deck.removeFirstCard());
            }
        }
    }

    private void signalGameStart() {
        System.out.println();
        System.out.println("Zaczynamy grę.");
    }

    private void drawFirstCard() {
        Card cardFromDeck = deck.removeFirstCard();
        addCardToDiscardPile(cardFromDeck);
    }

    private void addCardToDiscardPile(Card cardToBeAdded) {
        discardPile.add(cardToBeAdded);
    }

    private void start() {
        Card lastPlayedCard = discardPile.get(0);
        while (true) {
            for (Player current : players) {
                if (current.equals(getFirstPlayer())) {
                    displayMessageAboutLastPlayedCard(lastPlayedCard);
                }
                if (!current.canYouPlayCard(lastPlayedCard)) {
                    Card receivedCard = deck.removeFirstCard();
                    current.receiveCard(receivedCard);
                    System.out.println(current + " nie mógł nic zagrać, dobiera kartę. Otrzymana karta to: " + receivedCard);
                    continue;
                }
                lastPlayedCard = playCard(current, lastPlayedCard);
                checkIfMacau(current);
                if (checkIfGameEnd(current)) {
                    return;
                }
            }
        }
    }

    private void displayMessageAboutLastPlayedCard(Card lastPlayedCard) {
        System.out.println();
        System.out.println("Twoj ruch. Karta na stole to: " + lastPlayedCard);
    }

    private Card playCard(Player current, Card lastPlayedCard) {
        Card cardToPlay = current.selectCardToPlay(lastPlayedCard);
        current.getCards().remove(cardToPlay);
        discardPile.add(cardToPlay);
        System.out.println(current + " zagrał " + cardToPlay);
        return cardToPlay;
    }

    private void checkIfMacau(Player current) {
        if (current.getNumberOfCardsInHand() == 1) {
            System.out.println("Makao!");
        }
    }

    private boolean checkIfGameEnd(Player current) {
        if (current.getNumberOfCardsInHand() == 0) {
            System.out.println("I po makale! Koniec gry. Wygral " + current);
            return true;
        }
        return false;
    }

    public Player getFirstPlayer() {
        return players.get(0);
    }
}
