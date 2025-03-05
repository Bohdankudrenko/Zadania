import java.util.Scanner;

public class Zadanie3 {
    public static boolean czyJestParzysta(int a) {
        return a % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbę: ");
        int a = in.nextInt();
        System.out.println("Czy " + a + " jest parzysta? " + czyJestParzysta(a));
    }
}