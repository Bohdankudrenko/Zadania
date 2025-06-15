import java.util.Scanner;

public class Zadanie5 {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);

        System.out.print("Czy jest zniżka?: ");
        String znizkaInput = scanner.nextLine().toLowerCase();
        boolean jestZnizka = znizkaInput.equals("tak");

        System.out.print("Otrzymałes premię?: ");
        String premieInput = scanner.nextLine().toLowerCase();
        boolean otrzymalesPremie = premieInput.equals("nie");

        if(!jestZnizka || otrzymalesPremie){
            System.out.println("Możesz kupić samochód !");
            System.out.println("Zniżki na samochód nie ma");
        } else if(!jestZnizka || !otrzymalesPremie){
            System.out.println("Zakup samochód trzeba odłożyć na później...");
            System.out.println("Zniżki na samochód nie ma");
        } else if(jestZnizka || otrzymalesPremie){
            System.out.println("Możesz kupić samochód !");
        } else if(jestZnizka || !otrzymalesPremie){
            System.out.println("Nie ma takiego warunku");
        }
    }
}
