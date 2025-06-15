public class Zadanie2 {
    public static void main (String[] args){
        int [] tab = {2,4,6,8,10,12,14};
        int [] tab1 = {1,3,5,7,9,11,13};
        System.out.println("Co drugi element tablicy parzystej: ");
        for(int i=0; i<tab.length; i+=2){
            System.out.println(tab[i]);
        }
        System.out.println("Co drugi element tablicy nieparzystej: ");
        for(int i=0; i<tab1.length; i+=2){
            System.out.println(tab1[i]);
        }
    }
}
