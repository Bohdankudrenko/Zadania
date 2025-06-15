package Zadanie1;

public class Main {
    public static void main(String[] args) {
        Statek statek = new Statek();
        Samolot samolot = new Samolot();
        Amfibia amfibia = new Amfibia();

        statek.plyn();
        samolot.lec();
        amfibia.plyn();
        amfibia.lec();
    }
}
