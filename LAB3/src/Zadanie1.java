import java.util.Scanner;

public class Zadanie1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Podaj liczbę studentów: ");
        int n = scanner.nextInt();

        while (n <= 0) {
            System.out.print("Nieprawidłowa liczba studentów. Podaj jeszcze raz: ");
            n = scanner.nextInt();
        }


        int sumaPunktow = 0;
        int licznik = 0;


        while (licznik < n) {
            System.out.print("Podaj punkty dla studenta " + (licznik + 1) + ": ");
            int punkty = scanner.nextInt();


            if (punkty >= 0 && punkty <= 10) {
                sumaPunktow += punkty;
                licznik++;
            } else {
                System.out.println("Nieprawidłowa liczba punktów. Podaj liczbę od 0 do 10.");
            }
        }

        double srednia = (double) sumaPunktow / n;

        System.out.println("Średnia liczba punktów w grupie: " + srednia);

        scanner.close();
    }
}