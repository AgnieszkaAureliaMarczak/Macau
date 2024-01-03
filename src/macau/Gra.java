package macau;

import java.util.ArrayList;
import java.util.List;

public class Gra {
    private List<Card> stos = new ArrayList<>();
    private List<Player> gracze = new ArrayList<>();
    private Talia talia = new Talia(stos);
    private int liczbaGraczy;

    public void graj() {
        przygotuj();
        uruchom();
    }

    private void przygotuj() {
        powitaj();
        ustalLiczbeGraczy();
        talia.przygotujKarty();
        rozdajKarty();
        zapowiedzStartGry();
        przygotujPierwszaKarte();
    }

    public void powitaj() {
        System.out.println("Witaj w grze w makao!");
    }

    public void ustalLiczbeGraczy() {
        boolean wlasciwaLiczbaGraczy;
        do {
            System.out.println("Podaj liczbę graczy (od 2 do 6).");
            liczbaGraczy = ReadingNumberFromConsole.readNumber();
            wlasciwaLiczbaGraczy = true;
            if (liczbaGraczy < 2 || liczbaGraczy > 6) {
                System.out.println("Podana liczba graczy wykracza poza zakres 2-6.");
                wlasciwaLiczbaGraczy = false;
            }
        } while (!wlasciwaLiczbaGraczy);
        gracze.add(new Human(0));
        for (int i = 1; i < liczbaGraczy; i++) {
            gracze.add(new Komputer(i));
        }
        System.out.println("Jesteś graczem nr 1.");
    }

    public void rozdajKarty() {
        for (int i = 0; i < 5; i++) {
            for (Player player : gracze) {
                player.receiveCard(talia.usunPierwszaKarteZtalii());
            }
        }
    }

    private void przygotujPierwszaKarte() {
        Card odslonietaKarta = talia.usunPierwszaKarteZtalii();
        dolozKarteDoStosu(odslonietaKarta);
    }

    public Player dajPierwszegoGracza() {
        return gracze.get(0);
    }

    public void zapowiedzStartGry() {
        System.out.println();
        System.out.println("Zaczynamy grę.");
    }

    public void wyswietlKomunikatJakaKartaNaStosie(Card kartaNaStole) {
        System.out.println();
        System.out.println("Twoj ruch. Karta na stole to: " + kartaNaStole);
    }

    public void dolozKarteDoStosu(Card kartaDoWylozenia) {
        stos.add(kartaDoWylozenia);
    }

    public void uruchom() {
        Card odslonietaKarta = stos.get(0);
        boolean koniecGry = false;
        while (!koniecGry) {
            for (Player aktualny : gracze) {
                if (aktualny.equals(dajPierwszegoGracza())) {
                    wyswietlKomunikatJakaKartaNaStosie(odslonietaKarta);
                }
                if (!aktualny.canYouPlayCard(odslonietaKarta)) {
                    Card otrzymana = talia.usunPierwszaKarteZtalii();
                    aktualny.receiveCard(otrzymana);
                    System.out.println(aktualny + " nie mogl nic zagrac, dobiera kartę. Otrzymana karta to: " + otrzymana);
                    continue;
                }
                odslonietaKarta = zareagujGdyMoznaZagrac(aktualny, odslonietaKarta);
                sprawdzCzyMakao(aktualny);
                if (sprawdzCzyKoniecGry(aktualny)) {
                    koniecGry = true;
                }
            }
        }
    }

    public Card zareagujGdyMoznaZagrac(Player aktualny, Card odslonietaKarta) {
        Card wybranaKarta = aktualny.selectCardToPlay(odslonietaKarta);
        aktualny.getCards().remove(wybranaKarta);
        stos.add(wybranaKarta);
        System.out.println(aktualny + " zagrał " + wybranaKarta);
        return wybranaKarta;
    }

    private void sprawdzCzyMakao(Player aktualny) {
        if (aktualny.getNumberOfCardsInHand() == 1) {
            System.out.println("Makao!");
        }
    }

    private boolean sprawdzCzyKoniecGry(Player aktualny) {
        if (aktualny.getNumberOfCardsInHand() == 0) {
            System.out.println("I po makale! Koniec gry. Wygral " + aktualny);
            return true;
        }
        return false;
    }
}
