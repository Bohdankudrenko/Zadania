package Zadanie1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnikalneImiona {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> imiona = new HashSet<>();

        System.out.println("Wprowadzaj imiona (wpisz '-' aby zakończyć):");

        while (true) {
            String imie = scanner.nextLine().trim();
            if (imie.equals("-")) {
                break;
            }
            if (!imie.isEmpty()) {
                imiona.add(imie);
            }
        }

        System.out.println("Liczba unikalnych imion: " + imiona.size());
    }
}

