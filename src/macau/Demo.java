package macau;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Nominal nominal1 = Nominal.valueOf("DAMA");
        Kolor kolor = Kolor.KARO;
        System.out.println(Arrays.toString(Nominal.values()));
        System.out.println(nominal1);
        Nominal nominal = Nominal.DAMA;
        System.out.println(nominal.getNumerycznaWartosc());
        System.out.println(nominal.ordinal());
        System.out.println(nominal.name());
        System.out.println(nominal);

        switch (nominal1){
            case DWA -> {
            }
            case TRZY -> {
            }
            case CZTERY -> {
            }
            case PIEC -> {
            }
            case SZESC -> {
            }
            case SIEDEM -> {
            }
            case OSIEM -> {
            }
            case DZIEWIEC -> {
            }
            case DZIESIEC -> {
            }
            case WALET -> {
            }
            case DAMA -> System.out.println("Czesc dama");
            case KROL -> {
            }
            case AS -> {
            }
        }
    }
}
