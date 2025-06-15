package Zadanie3;

public class Trojkat extends Figura implements IFigury {
    private float podstawa, wysokosc;

    public Trojkat(float podstawa, float wysokosc) {
        this.podstawa = podstawa;
        this.wysokosc = wysokosc;
    }

    @Override
    public String opis() {
        return "Obiekt klasy Trojkat";
    }

    @Override
    public void skaluj(float skala) {
        podstawa *= skala;
        wysokosc *= skala;
    }

    @Override
    public float getPowierzchnia() {
        return 0.5f * podstawa * wysokosc;
    }

    @Override
    public boolean wPolu(Punkt p) {
        return p.x >= 0 && p.x <= podstawa && p.y >= 0 && p.y <= wysokosc;
    }
}

