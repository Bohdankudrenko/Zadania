import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void funkcjaKwadratowa(double a, double b, double c){

        if (a==0){
            System.out.println("Fukcja nie istnieje");
            return;
        }
        double delta = b*b-4*a*c;
        System.out.println("Funkcja: " + a + "x^2" + b + "x"+ c + " = 0");
        System.out.println("Delta: " + delta);
        if(delta>0){
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);
            System.out.println("x1 = %.2f" + x1);
            System.out.println("x2 = %.2f" + x2);
        }else if (delta==0){
            double x = (x = -b / (2*a));
            System.out.println("x = %.2f" + x);
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
