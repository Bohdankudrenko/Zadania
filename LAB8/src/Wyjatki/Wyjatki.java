package Wyjatki;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.*;

public class Wyjatki {
    public static void main(String[] args) {
        List<String> lista= new ArrayList<>();
        List<String> lisat1= new LinkedList<>();

        Set<String> zbior= new HashSet<>();
        Set<String> zbior1= new LinkedHashSet<>();
        Set<String> zbior2 = new TreeSet<>();

        zbior.add("poniedziałek");
        zbior.add("poniedziałek1");
        zbior.add("poniedziałek12");
        zbior.add("poniedziałek12233");

        zbior.remove("ponidziałek");

        lista.add("poniedziałek");
        lista.add("wtorerk");
        lista.add("środa");
       /* try{
            int wynik = 5/0;
        }
        catch (ArithmeticException e){
            System.out.println("nie można dzielić przez zero!");
        }

        finally{
            System.out.println("Blok finally ....");
        }
    }
    */


        //  public void wczytajPlik(String nazwaPliku) throws IOException{}

        //sprawdzWiek(5);

    }
}
/* public static void sprawdzWiek(int wiek) throws MojeWyjatki{
    if(wiek<18){
        throw new MojeWyjatki(String komunikat){
                super(komunikat);
        }
    }
}

 class MojeWyjatki extends Exception{
    public MojeWyjatki(String komunikat){
        super(komunikat);
    }
}
*/
