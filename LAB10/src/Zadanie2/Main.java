package Zadanie2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> users = new HashMap<>();

        while (true) {
            System.out.println("\n1. Dodaj użytkownika");
            System.out.println("2. Zaloguj się");
            System.out.println("3. Zakończ");
            System.out.print("Wybierz opcję: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Podaj login: ");
                    String newLogin = scanner.nextLine();
                    if (users.containsKey(newLogin)) {
                        System.out.println("Użytkownik o tym loginie już istnieje.");
                        break;
                    }
                    System.out.print("Podaj hasło: ");
                    String newPassword = scanner.nextLine();
                    users.put(newLogin, newPassword);
                    System.out.println("Użytkownik dodany.");
                    break;

                case "2":
                    System.out.print("Login: ");
                    String login = scanner.nextLine();
                    System.out.print("Hasło: ");
                    String password = scanner.nextLine();

                    if (!users.containsKey(login)) {
                        System.out.println("Nie znaleziono użytkownika.");
                    } else if (users.get(login).equals(password)) {
                        System.out.println("Zalogowano pomyślnie!");
                    } else {
                        System.out.println("Nieprawidłowe hasło.");
                    }
                    break;

                case "3":
                    System.out.println("Zamykanie programu...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Nieprawidłowa opcja.");
            }
        }
    }
}

