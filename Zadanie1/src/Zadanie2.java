import java.util.Scanner;

public class Zadanie2 {
    public static void obliczDwieLiczby() {
        Scanner in = new Scanner(System.in);

        System.out.println("Podaj pierwszą liczbę: ");
        float a = in.nextFloat();

        System.out.println("Podaj drugą liczbę: ");
        float b = in.nextFloat();

        float suma = a+b;
        float roznica = a-b;
        float iloczyn = a*b;

        System.out.println("Suma: " + suma);
        System.out.println("Różnica: " + roznica);
        System.out.println("Iloczyn: " + iloczyn);
    }

    public static void main(String[] args) {
        obliczDwieLiczby();
    }
}