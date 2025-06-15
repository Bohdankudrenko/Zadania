package Class;

public class Person {
    // pola
    String firstName, lastName;
    int age;
    String nrAlbumu, kierunek;


    final int wiek=34;
    Adres adres;

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public int getWiek() {
        return wiek;
    }
    public final void WypiszWike(int wiek){
        System.out.println("Metoda final, wiek "+ getWiek());
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNrAlbumu() {
        return nrAlbumu;
    }

    public void setNrAlbumu(String nrAlbumu) {
        this.nrAlbumu = nrAlbumu;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    //Metody
    public void View(){
        System.out.println("Imię: " +firstName
        +" Nazwisko: " +lastName+
        " Kierunek studiów: " + kierunek+
        " Nr Albumu: "+ nrAlbumu);
    }
    public String PersonData(){
        return "Witaj: "+ firstName + " "+ lastName + ", twój wiek: "+ age;
    }


    //konstruktor

    public Person(){
        this.firstName = null;
        this.lastName = null;
        this.age = 0;
        this.nrAlbumu = null;
        this.kierunek = null;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
