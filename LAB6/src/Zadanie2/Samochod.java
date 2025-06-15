package Zadanie2;

import java.util.Scanner;

public class Samochod {
    protected String marka;
    protected String model;
    protected String nadwozie;
    protected String kolor;
    protected int rokProdukcji;
    protected int przebieg;

    public Samochod(String marka, String model, String nadwozie, String kolor, int rokProdukcji, int przebieg) {
        this.marka = marka;
        this.model = model;
        this.nadwozie = nadwozie;
        this.kolor = kolor;
        this.rokProdukcji = rokProdukcji;
        this.przebieg = Math.max(0, przebieg); // zabezpieczenie
    }

    public Samochod() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj markę: ");
        marka = scanner.nextLine();
        System.out.print("Podaj model: ");
        model = scanner.nextLine();
        System.out.print("Podaj nadwozie: ");
        nadwozie = scanner.nextLine();
        System.out.print("Podaj kolor: ");
        kolor = scanner.nextLine();
        System.out.print("Podaj rok produkcji: ");
        rokProdukcji = scanner.nextInt();
        System.out.print("Podaj przebieg: ");
        int p = scanner.nextInt();
        przebieg = Math.max(0, p);
    }

    public void wypiszInfo() {
        System.out.println("Samochod: " + marka + " " + model);
        System.out.println("Nadwozie: " + nadwozie + ", Kolor: " + kolor);
        System.out.println("Rok produkcji: " + rokProdukcji + ", Przebieg: " + przebieg + " km");
    }
}
