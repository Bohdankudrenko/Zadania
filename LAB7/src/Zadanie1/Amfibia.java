package Zadanie1;

public class Amfibia implements Plywa, Lata {
    @Override
    public void plyn() {
        System.out.println("Amfibia płynie po wodzie.");
    }

    @Override
    public void lec() {
        System.out.println("Amfibia leci nad wodą.");
    }
}

