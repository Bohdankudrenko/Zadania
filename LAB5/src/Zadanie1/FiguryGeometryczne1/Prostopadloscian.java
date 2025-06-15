package Zadanie1.FiguryGeometryczne1;
// прямокутний паралелепіпед
public class Prostopadloscian {
    private double dlugosc, szerokosc, wysokosc;

    public Prostopadloscian(double dlugosc, double szerokosc, double wysokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    public double obliczPole() {
        return 2 * (dlugosc * szerokosc + dlugosc * wysokosc + szerokosc * wysokosc);
    }

    public double obliczObjetosc() {
        return dlugosc * szerokosc * wysokosc;
    }

    public void wyswietlDane() {
        System.out.println("Figura: Prostopadłościan");
        System.out.println("Długość: " + dlugosc + ", Szerokość: " + szerokosc + ", Wysokość: " + wysokosc);
        System.out.println("Pole całkowite: " + obliczPole());
        System.out.println("Objętość: " + obliczObjetosc());
    }
}
