package macau;

public class Human extends Player {

    public Human(int index) {
        super(index);
    }

    public Card selectCardToPlay(Card topCardOnDiscardPile) {
        printPlayersCards();
        Card wybranaKarta = ustalKarte();
        System.out.println();
        return wybranaKarta;
    }

    private Card ustalKarte() {
        boolean kartaWzakresie;
        int numerKarty;
        do {
            kartaWzakresie = true;
            System.out.println("Wpisz liczbę odpowiadającej karcie, którą chcesz wyłożyć.");
            numerKarty = FajniejszyScanner.pobierzLiczbe();
            if (numerKarty < 1 || numerKarty > getNumberOfCardsInHand()) {
                System.out.println("Podana liczba wykracza poza zakres twoich kart.");
                kartaWzakresie = false;
            }
        } while (!kartaWzakresie);
        numerKarty -= 1;
        return cards.get(numerKarty);
    }
}
