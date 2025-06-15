package Zadanie3;

import java.util.ArrayList;

public class Ksiegarnia {
    private String nazwa;
    private ArrayList<Ksiazka> ksiazki = new ArrayList<>();

    public Ksiegarnia(String nazwa) {
        this.nazwa = nazwa;
    }

    public void dodajKsiazke(Ksiazka ks) {
        ksiazki.add(ks);
    }

    public void wypiszWszystkie() {
        System.out.println("Ksiegarnia: " + nazwa + " ma w ofercie:");
        for (Ksiazka ks : ksiazki) {
            ks.wypiszInfo();

            // RZUTOWANIE i instanceof
            if (ks instanceof Podrecznik) {
                Podrecznik p = (Podrecznik) ks;
                System.out.println("-> To jest podręcznik.");
            } else if (ks instanceof Powiesc) {
                Powiesc p = (Powiesc) ks;
                System.out.println("-> To jest powieść.");
            }

            System.out.println();
        }
    }
}

