import java.util.Scanner;

public class Zadanie5 {
    public static boolean czyPalindrom(String slowo) {
        // Zamiana na małe litery, aby ignorować wielkość liter
        slowo = slowo.toLowerCase();

        // Usuwanie spacji i znaków specjalnych (opcjonalne, zależne od wymagań)
        slowo = slowo.replaceAll("[^a-z0-9]", "");

        int lewy = 0;
        int prawy = slowo.length() - 1;

        // Sprawdzanie znaków od początku i końca
        while (lewy < prawy) {
            if (slowo.charAt(lewy) != slowo.charAt(prawy)) {
                return false;
            }
            lewy++;
            prawy--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj słowo do sprawdzenia: ");
        String slowo = scanner.nextLine();

        if (slowo.isEmpty()) {
            System.out.println("Nie podano żadnego słowa!");
        } else if (czyPalindrom(slowo)) {
            System.out.println("Słowo " + slowo + " jest palindromem.");
        } else {
            System.out.println("Słowo " + slowo + " nie jest palindromem.");
        }

        scanner.close();
    }
}