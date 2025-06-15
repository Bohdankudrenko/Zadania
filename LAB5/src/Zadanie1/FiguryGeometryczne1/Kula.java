package Zadanie1.FiguryGeometryczne1;
// куля
public class Kula {
    private double promien;

    public Kula(double promien) {
        this.promien = promien;
    }

    public double obliczPole() {
        return 4 * Math.PI * promien * promien;
    }

    public double obliczObjetosc() {
        return (4.0 / 3.0) * Math.PI * Math.pow(promien, 3);
    }

    public void wyswietlDane() {
        System.out.println("Figura: Kula");
        System.out.println("Promień: " + promien);
        System.out.println("Pole powierzchni: " + obliczPole());
        System.out.println("Objętość: " + obliczObjetosc());
    }
}