import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iloscDodatnich = 0;
        int iloscUjemnych = 0;
        double sumaDodatnich = 0;
        double sumaUjemnych = 0;

        System.out.println("Podaj 10 liczb:");

        for (int i = 1; i <= 10; i++) {
            System.out.print("Liczba " + i + ": ");
            double liczba = scanner.nextDouble();

            if (liczba > 0) {
                iloscDodatnich++;
                sumaDodatnich += liczba;
            } else if (liczba < 0) {
                iloscUjemnych++;
                sumaUjemnych += liczba;
            }
        }

        System.out.println("\nWyniki:");
        System.out.println("Liczb dodatnich: " + iloscDodatnich);
        System.out.println("Suma liczb dodatnich: " + sumaDodatnich);
        System.out.println("Liczb ujemnych: " + iloscUjemnych);
        System.out.println("Suma liczb ujemnych: " + sumaUjemnych);

        scanner.close();
    }
}