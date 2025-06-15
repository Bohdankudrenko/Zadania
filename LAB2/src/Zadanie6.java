import java.util.Scanner;

public class Zadanie6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz działanie:");
        System.out.println("1. Dodawanie");
        System.out.println("2. Odejmowanie");
        System.out.println("3. Mnożenie");
        System.out.println("4. Dzielenie");
        System.out.println("5. Reszta z dzielenia");


        System.out.print("Podaj numer działania (1-5): ");
        int wybor = scanner.nextInt();


        if (wybor < 1 || wybor > 5) {
            System.out.println("Błąd: Wybierz numer od 1 do 5!");
            scanner.close();
            return;
        }


        System.out.print("Podaj pierwszą liczbę: ");
        double liczba1 = scanner.nextDouble();

        System.out.print("Podaj drugą liczbę: ");
        double liczba2 = scanner.nextDouble();

        switch (wybor) {
            case 1:
                double suma = liczba1 + liczba2;
                System.out.println("Wynik dodawania: " + liczba1 + " + " + liczba2 + " = " + suma);
                break;

            case 2:
                double roznica = liczba1 - liczba2;
                System.out.println("Wynik odejmowania: " + liczba1 + " - " + liczba2 + " = " + roznica);
                break;

            case 3:
                double iloczyn = liczba1 * liczba2;
                System.out.println("Wynik mnożenia: " + liczba1 + " * " + liczba2 + " = " + iloczyn);
                break;

            case 4:
                if (liczba2 == 0) {
                    System.out.println("Błąd: Nie można dzielić przez zero!");
                } else {
                    double iloraz = liczba1 / liczba2;
                    System.out.println("Wynik dzielenia: " + liczba1 + " / " + liczba2 + " = " + iloraz);
                }
                break;

            case 5:
                if (liczba2 == 0) {
                    System.out.println("Błąd: Nie można obliczyć reszty z dzielenia przez zero!");
                } else {
                    double reszta = liczba1 % liczba2;
                    System.out.println("Reszta z dzielenia: " + liczba1 + " % " + liczba2 + " = " + reszta);
                }
                break;

            default:
                System.out.println("Nieprawidłowy wybór!");
                break;
        }

        scanner.close();
    }
}