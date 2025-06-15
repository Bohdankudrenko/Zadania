package Zadanie2;

import java.time.LocalDate;

public class Budynek {

    private String nazwa;
    private int rok;
    private int liczbaPieter;

    public Budynek(String nazwa, int rok, int liczbaPieter){
        this.nazwa = nazwa;
        this.rok = rok;
        this.liczbaPieter = liczbaPieter;
    }

    public void wyswietlDane() {
        System.out.println("Nazwa: " + nazwa);
        System.out.println("Rok budowy: " + rok);
        System.out.println("Liczba pięter: " + liczbaPieter);
        System.out.println("Wiek budynku: " + obliczWiek() + " lat");
        }

    public int obliczWiek(){
        int obecnyRok = LocalDate.now().getYear();
        return obecnyRok - rok;
}
    public static void main(String[] args){
        Budynek b1 = new Budynek("Tower", 2015, 10);
        Budynek b2 = new Budynek("House", 1984, 14);
        Budynek b3 = new Budynek("Dream", 1995, 15);

        b1.wyswietlDane();
        System.out.println();

        b2.wyswietlDane();
        System.out.println();

        b3.wyswietlDane();
    }
}
