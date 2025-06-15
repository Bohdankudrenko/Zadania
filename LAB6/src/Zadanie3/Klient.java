package Zadanie3;

public class Klient {
    private String imie;
    private Ksiazka zakupionaKsiazka;

    public Klient(String imie) {
        this.imie = imie;
    }

    public void kupKsiazke(Ksiazka k) {
        this.zakupionaKsiazka = k;
        System.out.println(imie + " kupil(a) ksiazke:");
        k.wypiszInfo();
    }
}

