package WypPojazdow;

public abstract class Pojazd {
    protected String id;
    protected String model;
    protected Boolean czydostepny = true;

    public Pojazd(String id, String model) {
        this.id = id;
        this.model = model;
    }

    public void wypozycz(){
        czydostepny = false;
    }

    public void zwroc(){
        czydostepny = false;
    }

    public boolean isCzydostepny(){
        return czydostepny;
    }

    public String getId(){
        return id;
    }

    public String getModel(){
        return model;
    }

    public abstract double obliczKoszt(int liczba);
}
