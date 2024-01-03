package macau;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadingNumberFromConsole {
    private static Scanner scanner = new Scanner(System.in);

    public static int readNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Podana wartość nie jest liczbą. Podaj ponownie.");
            scanner = new Scanner(System.in);
            return readNumber();
        }
    }
}
