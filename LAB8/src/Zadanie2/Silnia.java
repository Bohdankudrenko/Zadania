package Zadanie2;

import java.util.Scanner;

// Własny wyjątek typu checked
class BlednaWartoscDlaSilniException extends Exception {
    public BlednaWartoscDlaSilniException(String message) {
        super(message);
    }
}

public class Silnia {

    // Metoda do obliczania silni
    public static long obliczSilnie(int n) throws BlednaWartoscDlaSilniException {
        if (n < 0) {
            throw new BlednaWartoscDlaSilniException("Nie można obliczyć silni z liczby ujemnej.");
        }

        long wynik = 1;
        for (int i = 2; i <= n; i++) {
            wynik *= i;
        }
        return wynik;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Podaj liczbę: ");
            int liczba = scanner.nextInt(); // Możesz też pobrać z Scanner
            long silnia = obliczSilnie(liczba);
            System.out.println("Silnia z " + liczba + " to: " + silnia);
        } catch (BlednaWartoscDlaSilniException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}
