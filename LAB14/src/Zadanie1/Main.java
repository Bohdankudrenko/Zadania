package Zadanie1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsersCRUD usersCRUD = new UsersCRUD();

        printBanner("ATM Bank");

        System.out.println("Podaj nazwe uzytkownika: ");
        String userName = scanner.nextLine();
        System.out.println("Podaj PIN: ");
        String pin = scanner.nextLine();

        try{
            if(usersCRUD.authenticateUser(userName, pin, "admin")){
                System.out.println("Zalogowano jako: ADMINISTRATOR");
                adminMenu(usersCRUD,scanner);
            }
            else if (usersCRUD.authenticateUser(userName, pin, "user")) {
                System.out.println("Zalogowano jako: UZYTKOWNIK");
                userMenu(usersCRUD, scanner, userName);
            }else{
                System.out.println("Niepoprawne dane logowania,");
            }
        } catch (Exception e){
            System.out.println("Wystapil blad: "+ e.getMessage());
        }
    }

    private static void userMenu(UsersCRUD usersCRUD, Scanner scanner, String userName) throws Exception{
        while (true){
            printBanner("\n Menu uzytkownika: ");

            System.out.println("1. Wplata pieniedzy");
            System.out.println("2. Wplata pieniedzy");
            System.out.println("3. Zmiana PIN-u");
            System.out.println("4. Saldo");
            System.out.println("5, Wyloguj sie");

            System.out.println("\n Wybierz opcje");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Podaj kwote do wplaty: ");
                    double depositAdmin = scanner.nextDouble();
                    usersCRUD.deposit(userName, depositAdmin);
                    break;
                case 2:
                    System.out.println("Podaj kwote do wyplaty: ");
                    double withdrawAmount = scanner.nextDouble();
                    usersCRUD.withDraw(userName, withdrawAmount);
                    break;
                case 3:
                    System.out.println("Podaj nowy PIN:");
                    String newPin = scanner.next();
                    usersCRUD.changePIN(userName, newPin);
                    break;
                case 4:

            }
        }
    }

    private static void adminMenu(UsersCRUD usersCRUD, Scanner scanner) throws Exception{
        while (true){
            System.out.println("\n Menu administratora: ");
            System.out.println("1. Dodaj nowego uztkownika");
            System.out.println("2. Dodaj nowego uztkownika");
        }
    }

    //Metoda do wyświetlenia glowengo baneru
    private static void printBanner(String title){
        System.out.println("\n" + "=".repeat(40));
        System.out.print(" "+ title);
        System.out.println("\n" + "=".repeat(40));
    }
}
