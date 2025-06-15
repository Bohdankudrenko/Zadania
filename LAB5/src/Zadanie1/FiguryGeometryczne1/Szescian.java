package Zadanie1.FiguryGeometryczne1;
// куб
public class Szescian {
    private double bok;

    public Szescian(double bok) {
        this.bok = bok;
    }

    public double obliczPole() {
        return 6 * bok * bok;
    }

    public double obliczObjetosc() {
        return bok * bok * bok;
    }

    public void wyswietlDane() {
        System.out.println("Figura: Sześcian");
        System.out.println("Bok: " + bok);
        System.out.println("Pole całkowite: " + obliczPole());
        System.out.println("Objętość: " + obliczObjetosc());
    }
}