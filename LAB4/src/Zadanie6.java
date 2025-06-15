import java.util.Scanner;

public class Zadanie6 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] tab = new int[5];

        System.out.println("Podaj 5 liczb: ");
        for(int i=0; i<tab.length; i++){
            System.out.println("Liczba" + (i+1) + ": ");
            tab[i] = scanner.nextInt();
        }

        System.out.println("Wpisane liczby: ");
        for(int liczba : tab){
            System.out.println(liczba);
        }

        System.out.println("\nSilnie dla podanych liczb:");
        for (int n : tab) {
            System.out.println(n + "! = " + silnia(n));
        }
        }

    public static double silnia(int n) {
        double wynik = 1;
        for (int i = 2; i <= n; i++) {
            wynik *= i;
        }
        return wynik;
    }
    }
