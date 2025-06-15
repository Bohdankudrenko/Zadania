import java.util.Random;
import java.util.Scanner;

public class Zadanie4 {
    public static boolean czyJestParzysta(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Podaj liczbę elementów ciągu (n): ");
        int n = scanner.nextInt();

        // Sprawdzamy czy n jest dodatnie
        if (n <= 0) {
            System.out.println("Liczba elementów musi być większa od 0!");
            return;
        }

        int sumaParzystych = 0;

        // Pobieramy n liczb i sumujemy parzyste
        for (int i = 1; i <= n; i++) {
            int liczba= random.nextInt(56)-10;
            System.out.println(liczba + " ");

            if (czyJestParzysta(liczba)) {
                sumaParzystych += liczba;
            }
        }

        System.out.println("Suma wszystkich liczb parzystych: " + sumaParzystych);

        scanner.close();
    }
}