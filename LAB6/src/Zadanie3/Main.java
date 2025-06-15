package Zadanie3;

public class Main {
    public static void main(String[] args) {
        Ksiegarnia empik = new Ksiegarnia("Empik");

        Podrecznik matma = new Podrecznik("Matematyka 1", "Kowalski", 45.99, "Matematyka");
        Powiesc fantasy = new Powiesc("Władca Pierścieni", "Tolkien", 59.99, "Fantasy");

        empik.dodajKsiazke(matma);
        empik.dodajKsiazke(fantasy);

        empik.wypiszWszystkie();

        Klient klient = new Klient("Ania");
        klient.kupKsiazke(fantasy);
    }
}

