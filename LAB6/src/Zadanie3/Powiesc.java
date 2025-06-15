package Zadanie3;

public class Powiesc extends Ksiazka {
    private String gatunek;

    public Powiesc(String tytul, String autor, double cena, String gatunek) {
        super(tytul, autor, cena);
        this.gatunek = gatunek;
    }

    @Override
    public void wypiszInfo() {
        super.wypiszInfo();
        System.out.println("Typ: Powiesc, Gatunek: " + gatunek);
    }
}

