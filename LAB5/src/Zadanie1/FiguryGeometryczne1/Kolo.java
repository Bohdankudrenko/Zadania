package Zadanie1.FiguryGeometryczne1;
// circle, коло
public class Kolo {
    private double promien;

    public Kolo(double promien) {
        this.promien = promien;
    }

    public double obliczPole() {
        return Math.PI * promien * promien;
    }

    public double obliczObwod() {
        return 2 * Math.PI * promien;
    }

    public void wyswietlDane() {
        System.out.println("Figura: Koło");
        System.out.println("Promień: " + promien);
        System.out.println("Pole: " + obliczPole());
        System.out.println("Obwód: " + obliczObwod());
    }
}
