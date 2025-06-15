package Zadanie3;

public class Okrag extends Figura implements IFigury, RuchFigury {
    private Punkt srodek;
    private float promien;

    public Okrag(Punkt srodek, float promien) {
        this.srodek = srodek;
        this.promien = promien;
    }

    @Override
    public void przesun(int x, int y) {
        srodek.x += x;
        srodek.y += y;
    }

    @Override
    public String opis() {
        return "Obiekt klasy Okrag";
    }

    @Override
    public void skaluj(float skala) {
        promien *= skala;
    }

    @Override
    public float getPowierzchnia() {
        return (float) (Math.PI * promien * promien);
    }

    @Override
    public boolean wPolu(Punkt p) {
        int dx = p.x - srodek.x;
        int dy = p.y - srodek.y;
        return dx * dx + dy * dy <= promien * promien;
    }
}
