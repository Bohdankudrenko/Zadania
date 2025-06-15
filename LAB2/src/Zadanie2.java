import java.util.Scanner;

public class Zadanie2{
    // Funkcja a(x)
    public static double funkcjaA(double x) {
        if (x > 0) {
            return x;
        } else if (x == 0) {
            return 0;
        } else {
            return -x * 3;  // dla x < 0
        }
    }

    // Funkcja b(x)
    public static double funkcjaB(double x) {
        if (x >= 1) {
            return x * x;  // x^2
        } else {
            return x + 1;
        }
    }

    // Funkcja c(x)
    public static double funkcjaC(double x) {
        if (x > 2) {
            return x * x + 8;  // x^2 + 8
        } else if (x == 2) {
            return 4;
        } else {
            return x - 2;  // dla x < 2
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pobieranie wartości x od użytkownika
        System.out.print("Podaj wartość x: ");
        double x = scanner.nextDouble();

        // Obliczanie i wyświetlanie wyników
        System.out.printf("a(%.2f) = %.2f%n", x, funkcjaA(x));
        System.out.printf("b(%.2f) = %.2f%n", x, funkcjaB(x));
        System.out.printf("c(%.2f) = %.2f%n", x, funkcjaC(x));

        // Zamknięcie skanera
        scanner.close();
    }
}