package Zadanie1.Inheritance;


public class Main {
    public static void main(String[] args) {
        Punkt p1 = new Punkt();
        Punkt p2 = new Punkt(2, 3);
        Punkt p3 = new Punkt(5, 7);

        p1.opis();
        p2.opis();
        p3.opis();

        p1.setX(10);
        p1.setY(20);
        p1.opis();

        p2.zeruj();
        p2.opis();

        p3.przesun(2, -3);
        p3.opis();

        Figura figura = new Figura("czerwony");
        Prostokat prostokat = new Prostokat(4, 5, "zielony");
        Trojkat trojkat = new Trojkat(3, 6, "niebieski");
        Okrag okrag = new Okrag(new Punkt(0, 0), 5);
        Kwadrat kwadrat = new Kwadrat(3, "zolty");

        System.out.println(figura.opis());
        System.out.println(prostokat.opis());
        System.out.println(trojkat.opis());
        System.out.println(okrag.opis());
        System.out.println(kwadrat.opis());

        prostokat.przesun(3, 5);
        System.out.println("Nowa pozycja prostokata: " + prostokat.punkt.x + ", " + prostokat.punkt.y);

        System.out.println("Czy punkt (2,2) jest w srodku okregu? " + okrag.wSrodku(new Punkt(2, 2)));
    }
}
