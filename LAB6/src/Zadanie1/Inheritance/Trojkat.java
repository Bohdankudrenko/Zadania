package Zadanie1.Inheritance;

public class Trojkat extends Figura {
    double wys = 0, podst = 0;

    Trojkat(double wys, double podst) {
        super();
        this.wys = wys;
        this.podst = podst;
    }

    public Trojkat(float wys, float podst, String kolor) {
        super(kolor);
        this.wys = wys;
        this.podst = podst;
    }

    @Override
    public String opis() {
        return "Trojkat o podstawie " + podst + " i wysokosci " + wys + ". Kolor: " + kolor;
    }
}

