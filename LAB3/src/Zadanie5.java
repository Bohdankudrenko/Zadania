import java.util.Scanner;

public class Zadanie5 {
    public static boolean czyPalindrom(String slowo) {
        slowo = slowo.toLowerCase();

        slowo = slowo.replaceAll("[^a-z0-9]", "");

        int lewy = 0;
        int prawy = slowo.length() - 1;

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