package Zadanie3;

public class Ksiazka {
    protected String tytul;
    protected String autor;
    protected double cena;

    public Ksiazka(String tytul, String autor, double cena) {
        this.tytul = tytul;
        this.autor = autor;
        this.cena = cena;
    }

    public void wypiszInfo() {
        System.out.println("Tytul: " + tytul + ", Autor: " + autor + ", Cena: " + cena + " PLN");
    }
}

