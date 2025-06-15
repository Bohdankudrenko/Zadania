package Zadanie1;

enum Swiatlo {
    CZERWONE("Stój!"),
    ZOLTE("Uwaga!"),
    ZIELONE("Jedź!");

    private String komunikat;

    Swiatlo(String komunikat) {
        this.komunikat = komunikat;
    }

    public String getKomunikat() {
        return komunikat;
    }
}

public class SwiatloTest {
    public static void main(String[] args) {
        Swiatlo aktualneSwiatlo = Swiatlo.CZERWONE; // można zmienić na ZOLTE lub ZIELONE

        System.out.println(aktualneSwiatlo.getKomunikat());
    }
}

