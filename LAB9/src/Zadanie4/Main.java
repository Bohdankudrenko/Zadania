package Zadanie4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tworzenie tablicy obiektów klasy Produkt
        Produkt[] produktyTablica = {
                new Produkt("Chleb", 3.50),
                new Produkt("Mleko", 2.80),
                new Produkt("Masło", 6.00),
                new Produkt("Ser", 5.50),
                new Produkt("Sok", 4.20)
        };

        // Wypełnianie listy ArrayList zawartością tablicy
        List<Produkt> listaProduktow = new ArrayList<>(Arrays.asList(produktyTablica));

        System.out.println("Oryginalna lista:");
        for (Produkt p : listaProduktow) {
            System.out.println(p);
        }

        // Wyłuskanie fragmentu listy metodą subList() – np. elementy 1 do 3 (indeksy 1, 2)
        List<Produkt> podlista = listaProduktow.subList(1, 3);

        System.out.println("\nPodlista (do usunięcia):");
        for (Produkt p : podlista) {
            System.out.println(p);
        }

        // Usunięcie podlisty z oryginalnej listy
        podlista.clear();  // Modyfikuje również oryginalną listę

        System.out.println("\nLista po usunięciu podlisty:");
        for (Produkt p : listaProduktow) {
            System.out.println(p);
        }
    }
}

