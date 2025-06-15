import java.util.Scanner;

public class Zadanie3{
    public static void sortThreeNumbers(double x, double y, double z) {
        double smallest, middle, largest;

        if (x <= y && x <= z) {
            smallest = x;
            if (y <= z) {
                middle = y;
                largest = z;
            } else {
                middle = z;
                largest = y;
            }
        } else if (y <= x && y <= z) {
            smallest = y;
            if (x <= z) {
                middle = x;
                largest = z;
            } else {
                middle = z;
                largest = x;
            }
        } else {
            smallest = z;
            if (x <= y) {
                middle = x;
                largest = y;
            } else {
                middle = y;
                largest = x;
            }
        }

        System.out.println("Posortowane liczby: " + smallest + ", " + middle + ", " + largest);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczby: ");

        System.out.println("x: ");
        double x = scanner.nextDouble();
        System.out.println("y: ");
        double y = scanner.nextDouble();
        System.out.println("z: ");
        double z = scanner.nextDouble();

        sortThreeNumbers(x,y,z);

        scanner.close();
    }

}



