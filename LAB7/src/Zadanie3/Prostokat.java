package Zadanie3;

public class Prostokat extends Figura implements IFigury {
    protected float szerokosc, wysokosc;

    public Prostokat(float szerokosc, float wysokosc) {
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    @Override
    public String opis() {
        return "Obiekt klasy Prostokat";
    }

    @Override
    public void skaluj(float skala) {
        szerokosc *= skala;
        wysokosc *= skala;
    }

    @Override
    public float getPowierzchnia() {
        return szerokosc * wysokosc;
    }

    @Override
    public boolean wPolu(Punkt p) {
        return p.x >= 0 && p.x <= szerokosc && p.y >= 0 && p.y <= wysokosc;
    }
}

