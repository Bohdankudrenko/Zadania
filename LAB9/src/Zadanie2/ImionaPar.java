package Zadanie2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ImionaPar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> pary = new HashMap<>();

        System.out.println("Wprowadzaj imiona par (wpisz '-' aby zakończyć):");

        while (true) {
            System.out.print("Podaj imię pierwszej osoby: ");
            String imie1 = scanner.nextLine().trim();
            if (imie1.equals("-")) break;

            System.out.print("Podaj imię partnera/partnerki dla " + imie1 + ": ");
            String imie2 = scanner.nextLine().trim();

            pary.put(imie1, imie2);
            pary.put(imie2, imie1);
        }

        System.out.print("Podaj imię, aby poznać imię partnera/partnerki: ");
        String szukaneImie = scanner.nextLine().trim();

        if (pary.containsKey(szukaneImie)) {
            System.out.println("Partner/partnerka dla " + szukaneImie + " to: " + pary.get(szukaneImie));
        } else {
            System.out.println("Nie znaleziono partnera/partnerki dla podanego imienia.");
        }
    }
}
