package Zadanie1.Inheritance;



public class Figura {

    //pola metody i kontruktory
    public Punkt punkt;
    protected String kolor = "bialy";


    public Figura(){
        punkt = new Punkt(0,0);
    }
    public Figura(String kolor){
        this.kolor=kolor;
        this.punkt = new Punkt(0, 0);
    }
    public Figura(Punkt punkt){
        this.punkt=punkt;
    }
    String getKolor(){
        return kolor;
    }
    public String opis(){
        return "Klasa Figura. Kolor obiektu: "+kolor;
    }


}

