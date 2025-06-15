import java.util.Arrays;
import java.util.Collections;

public class Zadanie7 {
    public static void main (String[] args){
        String[] tab = {"kot", "pies", "mysz"};
        String[] tab1 = {"kot", "pies", "mysz"};

        if(Arrays.equals(tab, tab1)){
            System.out.println("Tablicy są takie same");
        } else{
            System.out.println("Tablicy nie są takie same");
        }
    }
}
