package Zadanie1.Inheritance;

public class Okrag extends Figura {
    private double promien;

    public Okrag() {
        super();
        this.punkt = new Punkt(0, 0);
        this.promien = 0;
    }

    public Okrag(Punkt srodek, double promien) {
        super(srodek);
        this.promien = promien;
    }

    public double getPowierzchnia() {
        return Math.PI * promien * promien;
    }

    public double getSrednica() {
        return 2 * promien;
    }

    public void setPromien(double p) {
        this.promien = p;
    }

    public double getPromien() {
        return promien;
    }

    public boolean wSrodku(Punkt p) {
        int dx = p.x - punkt.x;
        int dy = p.y - punkt.y;
        return dx * dx + dy * dy <= promien * promien;
    }

    @Override
    public String opis() {
        return "Okrag o srodku w (" + punkt.x + ", " + punkt.y + ") i promieniu " + promien + ". Kolor: " + kolor;
    }
}
