package Zadanie1.FiguryGeometryczne1;
// квадрат
public class Kwadrat {
    private double bok;

    public Kwadrat(double bok) {
        this.bok = bok;
    }

    public double obliczPole() {
        return bok * bok;
    }

    public double obliczObwod() {
        return 4 * bok;
    }

    public void wyswietlDane() {
        System.out.println("Figura: Kwadrat");
        System.out.println("Bok: " + bok);
        System.out.println("Pole: " + obliczPole());
        System.out.println("Obwód: " + obliczObwod());    }
}