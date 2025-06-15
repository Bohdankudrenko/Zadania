import java.util.Scanner;

public class Zadanie4 {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);

        System.out.print("Czy pada deszcz?: ");
        String deszczInput = scanner.nextLine().toLowerCase();
        boolean padaDeszcz = deszczInput.equals("tak");

        System.out.print("Czy jest autobus na przystanku?: ");
        String autobusInput = scanner.nextLine().toLowerCase();
        boolean jestAutobus = autobusInput.equals("tak");

        if(padaDeszcz && jestAutobus){
            System.out.println("Weź parasol");
            System.out.println("Dostaniesz się na uczelnię");
        } else if(padaDeszcz && !jestAutobus){
            System.out.println("Nie dostaniesz się na uczelnię");
        } else if(!padaDeszcz && jestAutobus){
            System.out.println("Dostaniesz się na uczelnię");
            System.out.println("Miłego dnia i pięknej pogody");
        } else if(!padaDeszcz && !jestAutobus){
            System.out.println("Nie ma takiego warunku");
        }
    }
}
