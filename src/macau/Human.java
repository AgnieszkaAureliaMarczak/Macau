package macau;

public class Human extends Player {

    public Human(int index) {
        super(index);
    }

    public Card selectCardToPlay(Card topCardOnDiscardPile) {
        printPlayersCards();
        Card selectedCard = getCardToPlay();
        System.out.println();
        return selectedCard;
    }

    private Card getCardToPlay() {
        boolean correctCard;
        int cardNumber;
        do {
            correctCard = true;
            System.out.println("Wpisz liczbę odpowiadającej karcie, którą chcesz wyłożyć.");
            cardNumber = ReadingNumberFromConsole.readNumber();
            if (cardNumber < 1 || cardNumber > getNumberOfCardsInHand()) {
                System.out.println("Podana liczba wykracza poza zakres twoich kart.");
                correctCard = false;
            }
        } while (!correctCard);
        cardNumber -= 1;
        return cards.get(cardNumber);
    }
}
