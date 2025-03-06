import java.util.Scanner;

public class Zadanie6 {
    public static double squareRoot(double number) {
        return Math.sqrt(number);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbę do obliczenia pierwiastka: ");
        double number = in.nextDouble();
        System.out.println("Pierwiastek z " + number + " = " + squareRoot(number));
    }
}