import java.util.Scanner;

public class Zadanie5 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int [] tab = new int[8];

        System.out.println("Podaj 8 liczb: ");
        for(int i=0; i< tab.length; i++){
            System.out.println("Liczba" + (i+1) + ": ");
            tab[i] = scanner.nextInt();
        }

        System.out.println("\nWpisane liczby: ");
        for(int tablica : tab){
            System.out.println(tablica);
        }

        for (int i = 1; i < tab.length; i++) {
            int sor = tab[i];
            int j = i - 1;

            while (j >= 0 && tab[j] > sor) {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = sor;
        }

        System.out.println("\nTablica posortowana rosnąco:");
        for (int liczba : tab) {
            System.out.println(liczba);
        }
    }
}
