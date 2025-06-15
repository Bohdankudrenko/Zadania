package Zadanie5;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista1 = new ArrayList<>();
        lista1.add(10);
        lista1.add(20);
        lista1.add(30);
        lista1.add(40);
        lista1.add(50);

        List<Integer> lista2 = new ArrayList<>();

        ListIterator<Integer> iterator = lista1.listIterator(lista1.size());

        while (iterator.hasPrevious()) {
            Integer liczba = iterator.previous();
            lista2.add(liczba);
        }

        System.out.println("Lista 1 (oryginalna): " + lista1);
        System.out.println("Lista 2 (odwrotna):   " + lista2);
    }
}

