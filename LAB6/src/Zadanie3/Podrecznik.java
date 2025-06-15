package Zadanie3;

public class Podrecznik extends Ksiazka {
    private String przedmiot;

    public Podrecznik(String tytul, String autor, double cena, String przedmiot) {
        super(tytul, autor, cena);
        this.przedmiot = przedmiot;
    }

    @Override
    public void wypiszInfo() {
        super.wypiszInfo();
        System.out.println("Typ: Podrecznik, Przedmiot: " + przedmiot);
    }
}

