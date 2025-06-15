package Zadanie3;

import java.util.Objects;

public class Uczestnik {
    private int id;
    private String imie;
    private int wiek;

    public Uczestnik(int id, String imie, int wiek) {
        this.id = id;
        this.imie = imie;
        this.wiek = wiek;
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public int getWiek() {
        return wiek;
    }

    @Override
    public String toString() {
        return "Uczestnik{" +
                "ID=" + id +
                ", imię='" + imie + '\'' +
                ", wiek=" + wiek +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Uczestnik)) return false;
        Uczestnik that = (Uczestnik) o;
        return id == that.id && wiek == that.wiek && Objects.equals(imie, that.imie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imie, wiek);
    }
}

