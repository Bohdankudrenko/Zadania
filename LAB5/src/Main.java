import Zadanie1.FiguryGeometryczne1.Kolo;
import Zadanie1.FiguryGeometryczne1.Kula;
import Zadanie1.FiguryGeometryczne1.Kwadrat;
import Zadanie1.FiguryGeometryczne1.Stozek;
import Zadanie1.FiguryGeometryczne1.Prostokat;
import Zadanie1.FiguryGeometryczne1.Prostopadloscian;
import Zadanie1.FiguryGeometryczne1.Szescian;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("FIGURY PŁASKIE");
        Kolo kolo = new Kolo(5);
        kolo.wyswietlDane();
        System.out.println();

        Kwadrat kwadrat = new Kwadrat(4);
        kwadrat.wyswietlDane();
        System.out.println();

        Prostokat prostokat = new Prostokat(3, 6);
        prostokat.wyswietlDane();
        System.out.println();

        System.out.println("FIGURY PRZESTRZENNE");

        Szescian szescian = new Szescian(2);
        szescian.wyswietlDane();
        System.out.println();

        Prostopadloscian prostopadloscian = new Prostopadloscian(2, 3, 4);
        prostopadloscian.wyswietlDane();
        System.out.println();

        Kula kula = new Kula(3);
        kula.wyswietlDane();
        System.out.println();

        Stozek stozek = new Stozek(3, 5);
        stozek.wyswietlDane();





        Scanner scanner = new Scanner(System.in);
        int wybor;

        do {
            System.out.println("\nKALKULATOR FIGUR GEOMETRYCZNYCH");
            System.out.println("1. Koło");
            System.out.println("2. Kwadrat");
            System.out.println("3. Prostokąt");
            System.out.println("4. Sześcian");
            System.out.println("5. Prostopadłościan");
            System.out.println("6. Kula");
            System.out.println("7. Stożek");
            System.out.println("0. Zakończ");
            System.out.print("Wybierz figurę: ");
            wybor = scanner.nextInt();

            switch (wybor) {
                case 1 -> {
                    System.out.print("Podaj promień: ");
                    double r = scanner.nextDouble();
                    Kolo kolo1 = new Kolo(r);
                    kolo1.wyswietlDane();
                }
                case 2 -> {
                    System.out.print("Podaj bok: ");
                    double a = scanner.nextDouble();
                    Kwadrat kwadrat1 = new Kwadrat(a);
                    kwadrat1.wyswietlDane();
                }
                case 3 -> {
                    System.out.print("Podaj długość: ");
                    double dl = scanner.nextDouble();
                    System.out.print("Podaj szerokość: ");
                    double sz = scanner.nextDouble();
                    Prostokat prostokat1 = new Prostokat(dl, sz);
                    prostokat1.wyswietlDane();
                }
                case 4 -> {
                    System.out.print("Podaj bok: ");
                    double b = scanner.nextDouble();
                    Szescian szescian1 = new Szescian(b);
                    szescian1.wyswietlDane();
                }
                case 5 -> {
                    System.out.print("Podaj długość: ");
                    double dl = scanner.nextDouble();
                    System.out.print("Podaj szerokość: ");
                    double sz = scanner.nextDouble();
                    System.out.print("Podaj wysokość: ");
                    double wys = scanner.nextDouble();
                    Prostopadloscian p = new Prostopadloscian(dl, sz, wys);
                    p.wyswietlDane();
                }
                case 6 -> {
                    System.out.print("Podaj promień: ");
                    double r = scanner.nextDouble();
                    Kula kula1 = new Kula(r);
                    kula1.wyswietlDane();
                }
                case 7 -> {
                    System.out.print("Podaj promień: ");
                    double r = scanner.nextDouble();
                    System.out.print("Podaj wysokość: ");
                    double h = scanner.nextDouble();
                    Stozek stozek1 = new Stozek(r, h);
                    stozek1.wyswietlDane();
                }
                case 0 -> System.out.println("Zakończono działanie programu.");
                default -> System.out.println("Nieprawidłowy wybór!");
            }

        } while (wybor != 0);

        scanner.close();
    }
}