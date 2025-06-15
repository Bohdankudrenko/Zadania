package Zadanie3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static List<Uczestnik> filtrujNiepelnoletnich(List<Uczestnik> uczestnicy) {
        List<Uczestnik> niepelnoletni = new ArrayList<>();
        for (Uczestnik u : uczestnicy) {
            if (u.getWiek() < 18) {
                niepelnoletni.add(u);
            }
        }
        return niepelnoletni;
    }

    public static void main(String[] args) {
        List<Uczestnik> listaArray = new ArrayList<>();
        listaArray.add(new Uczestnik(1, "Jan", 20));
        listaArray.add(new Uczestnik(2, "Ola", 17));
        listaArray.add(new Uczestnik(3, "Adam", 16));

        System.out.println("Uczestnicy (ArrayList):");
        for (Uczestnik u : listaArray) {
            System.out.println(u);
        }

        List<Uczestnik> niepelnoletniArray = filtrujNiepelnoletnich(listaArray);
        System.out.println("\nNiepełnoletni (ArrayList):");
        for (Uczestnik u : niepelnoletniArray) {
            System.out.println(u);
        }

        List<Uczestnik> listaLinked = new LinkedList<>();
        listaLinked.add(new Uczestnik(4, "Ewa", 25));
        listaLinked.add(new Uczestnik(5, "Michał", 15));
        listaLinked.add(new Uczestnik(6, "Kasia", 17));

        System.out.println("\nUczestnicy (LinkedList):");
        for (Uczestnik u : listaLinked) {
            System.out.println(u);
        }

        List<Uczestnik> niepelnoletniLinked = filtrujNiepelnoletnich(listaLinked);
        System.out.println("\nNiepełnoletni (LinkedList):");
        for (Uczestnik u : niepelnoletniLinked) {
            System.out.println(u);
        }
    }
}
