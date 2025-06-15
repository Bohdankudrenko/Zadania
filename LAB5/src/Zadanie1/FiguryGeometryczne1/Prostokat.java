package Zadanie1.FiguryGeometryczne1;
// прямокутник
public class Prostokat {
    private double dlugosc, szerokosc;

    public Prostokat(double dlugosc, double szerokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
    }

    public double obliczPole() {
        return dlugosc * szerokosc;
    }

    public double obliczObwod() {
        return 2 * (dlugosc + szerokosc);
    }

    public void wyswietlDane() {
        System.out.println("Figura: Prostokąt");
        System.out.println("Długość: " + dlugosc + ", Szerokość: " + szerokosc);
        System.out.println("Pole: " + obliczPole());
        System.out.println("Obwód: " + obliczObwod());
    }
}
