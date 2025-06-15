package Zadanie2;

import java.util.Scanner;

public class SamochodOsobowy extends Samochod {
    private double waga;
    private double pojemnoscSilnika;
    private int iloscOsob;

    public SamochodOsobowy() {
        super(); // wywołanie konstruktora z klasy bazowej
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj wagę (2.0 - 4.5 t): ");
        double w = scanner.nextDouble();
        waga = (w >= 2.0 && w <= 4.5) ? w : 2.0;

        System.out.print("Podaj pojemność silnika (0.8 - 3.0 l): ");
        double ps = scanner.nextDouble();
        pojemnoscSilnika = (ps >= 0.8 && ps <= 3.0) ? ps : 0.8;

        System.out.print("Podaj ilość osób: ");
        iloscOsob = scanner.nextInt();
    }

    @Override
    public void wypiszInfo() {
        super.wypiszInfo();
        System.out.println("Waga: " + waga + " t, Pojemność silnika: " + pojemnoscSilnika + " l");
        System.out.println("Liczba osób: " + iloscOsob);
    }
}
