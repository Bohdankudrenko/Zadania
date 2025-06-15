package Zadanie5;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        // Utwórz pierwszą listę i ją zapełnij
        List<Integer> lista1 = new ArrayList<>();
        lista1.add(10);
        lista1.add(20);
        lista1.add(30);
        lista1.add(40);
        lista1.add(50);

        // Utwórz drugą pustą listę
        List<Integer> lista2 = new ArrayList<>();

        // Utwórz ListIterator na końcu listy1 (dla odwrotnego przejścia)
        ListIterator<Integer> iterator = lista1.listIterator(lista1.size());

        // Iteracja wsteczna i dodawanie do lista2
        while (iterator.hasPrevious()) {
            Integer liczba = iterator.previous();
            lista2.add(liczba);
        }

        // Wyświetlenie obu list
        System.out.println("Lista 1 (oryginalna): " + lista1);
        System.out.println("Lista 2 (odwrotna):   " + lista2);
    }
}

