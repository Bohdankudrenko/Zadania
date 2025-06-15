package Zadanie3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Reprezentacja wszystkich klas
        Prostokat p1 = new Prostokat(10, 5);
        Trojkat t1 = new Trojkat(6, 4);
        Kwadrat k1 = new Kwadrat(5);
        Okrag o1 = new Okrag(new Punkt(0, 0), 3);

        // Przykładowe funkcje
        p1.skaluj(2);
        System.out.println(t1.opis());
        o1.przesun(3, 4);

        // Tablica figur
        Figura[] tablicaFigur = new Figura[10];
        tablicaFigur[0] = p1;
        tablicaFigur[1] = t1;
        tablicaFigur[2] = k1;
        tablicaFigur[3] = o1;

        for (Figura f : tablicaFigur) {
            if (f != null) {
                System.out.println(f.opis());
            }
        }

        // Lista IFigury
        List<IFigury> listaFigur = new ArrayList<>();
        listaFigur.add(p1);
        listaFigur.add(k1);
        listaFigur.add(t1);
        listaFigur.add(o1);

        Punkt testPunkt = new Punkt(2, 2);
        for (IFigury fig : listaFigur) {
            System.out.println("Powierzchnia: " + fig.getPowierzchnia());
            System.out.println("Czy w polu (2,2)? " + fig.wPolu(testPunkt));
        }
    }
}

