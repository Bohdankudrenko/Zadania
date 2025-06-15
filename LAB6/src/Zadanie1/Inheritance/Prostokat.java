package Zadanie1.Inheritance;

public class Prostokat extends Figura {
    double wys = 0, szer = 0;

    Prostokat(double wys, double szer) {
        super();
        this.wys = wys;
        this.szer = szer;
    }

    public Prostokat(float wys, float szer, String kolor) {
        super(kolor);
        this.wys = wys;
        this.szer = szer;
    }

    public void przesun(float x, float y) {
        punkt.x += (int) x;
        punkt.y += (int) y;
    }

    @Override
    public String opis() {
        return "Prostokat o szerokosci " + szer + " i wysokosci " + wys + ". Kolor: " + kolor;
    }
}

