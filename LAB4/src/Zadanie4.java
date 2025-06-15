import java.util.Scanner;

public class Zadanie4 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        String [] tab = new String[5];

        System.out.println("Podaj 5 słów: ");
        for(int i=0; i< tab.length; i++){
            System.out.println("Słowo" + (i+1) + ": ");
            tab[i] = scanner.next();
        }

        System.out.println("Wpisane słowa: ");
        for (String slowo : tab){
            System.out.println(slowo);
        }

        System.out.println("\nOdwrócone słowa: ");
        for(int i = tab.length-1; i>=0; i--){
            String odwrocone = new StringBuilder(tab[i]).reverse().toString();
            System.out.println(odwrocone);
        }
        scanner.close();
    }
}
