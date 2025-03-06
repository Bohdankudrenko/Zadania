import java.util.Scanner;

public class Zadanie5 {
    public static float kub(float liczba) {
        return liczba * liczba * liczba;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbę do podniesienia do potęgi 3: ");
        float liczba = in.nextFloat();
        System.out.println(liczba + " do potęgi 3 = " + kub(liczba));
    }
}