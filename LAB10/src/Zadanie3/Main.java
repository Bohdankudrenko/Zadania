package Zadanie3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> menu = new LinkedHashMap<>(); // zachowuje kolejność dodawania

        while (true) {
            System.out.println("\n== MENU ==");
            System.out.println("1. Dodaj danie");
            System.out.println("2. Wyświetl kartę dań");
            System.out.println("3. Usuń danie");
            System.out.println("4. Oblicz rachunek");
            System.out.println("5. Wyjście");
            System.out.print("Wybierz opcję: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Nazwa dania: ");
                    String dish = scanner.nextLine();
                    System.out.print("Cena (zł): ");
                    try {
                        double price = Double.parseDouble(scanner.nextLine());
                        menu.put(dish, price);
                        System.out.printf("Dodano: %s – %.2f zł\n", dish, price);
                    } catch (NumberFormatException e) {
                        System.out.println("Nieprawidłowy format ceny.");
                    }
                    break;

                case "2":
                    if (menu.isEmpty()) {
                        System.out.println("Karta dań jest pusta.");
                    } else {
                        System.out.println("Karta dań:");
                        for (Map.Entry<String, Double> entry : menu.entrySet()) {
                            System.out.printf("- %s: %.2f zł\n", entry.getKey(), entry.getValue());
                        }
                    }
                    break;

                case "3":
                    System.out.print("Podaj nazwę dania do usunięcia: ");
                    String toRemove = scanner.nextLine();
                    if (menu.containsKey(toRemove)) {
                        menu.remove(toRemove);
                        System.out.println("Danie usunięto.");
                    } else {
                        System.out.println("Nie znaleziono takiego dania.");
                    }
                    break;

                case "4":
                    System.out.println("Podaj nazwy dań oddzielone przecinkami (np. Pizza, Zupa):");
                    String line = scanner.nextLine();
                    String[] selectedDishes = line.split(",");
                    double total = 0.0;
                    List<String> foundDishes = new ArrayList<>();

                    for (String item : selectedDishes) {
                        String trimmed = item.trim();
                        if (menu.containsKey(trimmed)) {
                            total += menu.get(trimmed);
                            foundDishes.add(trimmed);
                        } else {
                            System.out.println("Nie znaleziono dania: " + trimmed);
                        }
                    }

                    if (!foundDishes.isEmpty()) {
                        System.out.printf("Rachunek za %s: %.2f zł\n", foundDishes, total);
                    } else {
                        System.out.println("Nie wybrano żadnych poprawnych dań.");
                    }
                    break;

                case "5":
                    System.out.println("Zamknięcie aplikacji...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Nieprawidłowa opcja.");
            }
        }
    }
}

