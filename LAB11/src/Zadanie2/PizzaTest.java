package Zadanie2;

enum PizzaSize {
    MALA(25, 19.99),
    SREDNIA(30, 24.99),
    DUZA(40, 32.99);

    private int srednica;  // w cm
    private double cena;   // cena w złotych

    PizzaSize(int srednica, double cena) {
        this.srednica = srednica;
        this.cena = cena;
    }

    public int getSrednica() {
        return srednica;
    }

    public double getCena() {
        return cena;
    }
}

public class PizzaTest {
    public static void main(String[] args) {
        System.out.println("Duża pizza ma średnicę: " + PizzaSize.DUZA.getSrednica() + " cm");
        System.out.println("Cena dużej pizzy: " + PizzaSize.DUZA.getCena() + " zł");
    }
}

