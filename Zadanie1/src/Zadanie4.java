import java.util.Scanner;

public class Zadanie4 {
    public static boolean czyJestPodzielnaPrzez3I5(int liczba) {
        return liczba % 3 == 0 && liczba % 5 == 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczba jest podzielna przez 3 i 5: ");
        int liczba = in.nextInt();
        System.out.println("Czy " + liczba + " jest podzielna przez 3 i 5? " + czyJestPodzielnaPrzez3I5(liczba));
    }
}