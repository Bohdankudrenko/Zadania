import java.util.Scanner;

public class Zadanie1 {
    public static void funkcjaKwadratowa(double a, double b, double c){

        if (a==0){
            System.out.println("Fukcja nie istnieje");
            return;
        }
        double delta = b*b-4*a*c;
        System.out.println("Funkcja: " + a + "x^2 + " + b + "x + "+ c + " = 0");
        System.out.println("Delta: " + delta);
        if(delta>0){
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);
            System.out.printf("x1 = %.2f%n", x1);
            System.out.printf("x2 = %.2f%n", x2);
        }else if (delta==0){
            double x = -b / (2*a);
            System.out.printf("x = %.2f%n", x);
        }

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczby: ");

        System.out.println("a: ");
        double a = scanner.nextDouble();
        System.out.println("b: ");
        double b = scanner.nextDouble();
        System.out.println("c: ");
        double c = scanner.nextDouble();

        funkcjaKwadratowa(a,b,c);

        scanner.close();
    }
}
