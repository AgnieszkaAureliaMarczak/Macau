package macau;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FajniejszyScanner {
    private static Scanner scanner = new Scanner(System.in);

    public static int pobierzLiczbe() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Podana wartość nie jest liczbą. Podaj ponownie.");
            scanner = new Scanner(System.in);
            return pobierzLiczbe();
        }
    }
}
