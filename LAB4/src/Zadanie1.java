import java.util.Random;

public class Zadanie1 {
    public static void main(String[] args) {
        int[] tablica = new int[10];
        int a = 50;
        int b = 100;

        Random ran = new Random();

        for (int i = 0; i < tablica.length; i++) {
            tablica[i] = ran.nextInt(b - a + 1) + a;
        }


        System.out.print("Tablica: ");
        for (int x : tablica) {
            System.out.print(x + " ");
        }

        int suma =0;
        for (int i = 0; i < tablica.length; i++) {
            suma += tablica[i];
        }

        double srednia = (double) suma / tablica.length;

        System.out.println("\n\nSuma: " + suma);
        System.out.println("Średnia: " + srednia);


        int suma1 = 0;
        for (int element : tablica) {
            suma1 += element;
        }

        double srednia1 = (double) suma1 / tablica.length;

        System.out.println("\nSuma: " + suma1);
        System.out.println("Średnia: " + srednia1);
    }
}
