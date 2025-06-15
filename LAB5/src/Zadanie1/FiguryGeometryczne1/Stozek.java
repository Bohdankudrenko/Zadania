package Zadanie1.FiguryGeometryczne1;
//конус
public class Stozek {
    private double promien, wysokosc;

    public Stozek(double promien, double wysokosc) {
        this.promien = promien;
        this.wysokosc = wysokosc;
    }

    public double obliczPole() {
        double l = Math.sqrt(promien * promien + wysokosc * wysokosc); // tworząca
        return Math.PI * promien * (promien + l);
    }

    public double obliczObjetosc() {
        return (1.0 / 3.0) * Math.PI * promien * promien * wysokosc;
    }

    public void wyswietlDane() {
        System.out.println("Figura: Stożek");
        System.out.println("Promień: " + promien + ", Wysokość: " + wysokosc);
        System.out.println("Pole powierzchni: " + obliczPole());
        System.out.println("Objętość: " + obliczObjetosc());
    }
}
