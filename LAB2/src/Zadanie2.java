import java.util.Scanner;

public class Zadanie2{

    public static double funkcjaA(double x) {
        if (x > 0) {
            return x;
        } else if (x == 0) {
            return 0;
        } else {
            return -x * 3;
        }
    }


    public static double funkcjaB(double x) {
        if (x >= 1) {
            return x * x;
        } else {
            return x + 1;
        }
    }


    public static double funkcjaC(double x) {
        if (x > 2) {
            return x * x + 8;
        } else if (x == 2) {
            return 4;
        } else {
            return x - 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj wartość x: ");
        double x = scanner.nextDouble();

        System.out.printf("a(%.2f) = %.2f%n", x, funkcjaA(x));
        System.out.printf("b(%.2f) = %.2f%n", x, funkcjaB(x));
        System.out.printf("c(%.2f) = %.2f%n", x, funkcjaC(x));

        scanner.close();
    }
}