package Zadanie3;

public class Gatunek {
    private String rodzaj;
    private String gatunek;
    private int liczbaChromosomow2n;
    private int liczbaChromosomowX;
    private String opis;

    public Gatunek(String rodzaj, String gatunek, int liczbaChromosomow2n, int liczbaChromosomowX, String opis) {
        this.rodzaj = rodzaj;
        this.gatunek = gatunek;
        this.liczbaChromosomow2n = liczbaChromosomow2n;
        this.liczbaChromosomowX = liczbaChromosomowX;
        this.opis = opis;
    }

    public String pobierzPelnaNazwe() {
        return rodzaj + " " + gatunek;
    }

    public int pobierzLiczbeHaploidalna() {
        return liczbaChromosomow2n / 2;
    }

    public void wyswietlDane() {
        System.out.println("Pełna nazwa: " + pobierzPelnaNazwe());
        System.out.println("Liczba chromosomów 2n: " + liczbaChromosomow2n);
        System.out.println("Podstawowa liczba chromosomów x: " + liczbaChromosomowX);
        System.out.println("Liczba haploidalna n: " + pobierzLiczbeHaploidalna());
        System.out.println("Opis: " + opis);
    }

    public Gatunek klonuj() {
        return new Gatunek(rodzaj, gatunek, liczbaChromosomow2n, liczbaChromosomowX, opis);
    }

    public static void main(String[] args) {
        Gatunek g1 = new Gatunek("Homo", "sapiens", 46, 23, "Człowiek współczesny");
        Gatunek g2 = new Gatunek("Pan", "troglodytes", 48, 24, "Szympans zwyczajny");
        Gatunek g3 = new Gatunek("Canis", "lupus", 78, 39, "Wilk szary");

        System.out.println("= Gatunek 1 =");
        g1.wyswietlDane();

        System.out.println("\n= Gatunek 2 =");
        g2.wyswietlDane();

        System.out.println("\n= Gatunek 3 =");
        g3.wyswietlDane();

        System.out.println("\n= Klonowanie g1 =");
        Gatunek klonG1 = g1.klonuj();
        klonG1.wyswietlDane();
    }
}
