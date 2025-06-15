package Zadanie1;

import java.util.Scanner;

public class Pierwiastek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę: ");
        String input = scanner.nextLine();

        try {
            double liczba = Double.parseDouble(input);

            if (liczba < 0) {
                throw new IllegalArgumentException("Nie można obliczyć pierwiastka z liczby ujemnej.");
            }

            double pierwiastek = Math.sqrt(liczba);
            System.out.println("Pierwiastek z " + liczba + " to: " + pierwiastek);

        } catch (NumberFormatException e) {
            System.out.println("Błąd: Wprowadzono nieprawidłową liczbę.");
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}

