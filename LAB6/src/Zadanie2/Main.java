package Zadanie2;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Samochod osobowy ---");
        SamochodOsobowy osobowy = new SamochodOsobowy();

        System.out.println("\n--- Samochod 1 (dane z konstruktora parametrowego) ---");
        Samochod s1 = new Samochod("Toyota", "Corolla", "sedan", "szary", 2010, 180000);

        System.out.println("\n--- Samochod 2 (dane od użytkownika) ---");
        Samochod s2 = new Samochod();

        System.out.println("\n*** INFORMACJE O SAMOCHODACH ***\n");
        osobowy.wypiszInfo();
        System.out.println();
        s1.wypiszInfo();
        System.out.println();
        s2.wypiszInfo();
    }
}

