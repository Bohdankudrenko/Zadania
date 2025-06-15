package Zadanie3;

// Własny wyjątek typu checked
class NieprawidlowyAdresException extends Exception {
    public NieprawidlowyAdresException(String message) {
        super(message);
    }
}

// Klasa Adres
public class Adres {
    private String ulica;
    private int numerDomu;
    private String kodPocztowy;
    private String miasto;

    public Adres(String ulica, int numerDomu, String kodPocztowy, String miasto)
            throws NieprawidlowyAdresException {

        StringBuilder blad = new StringBuilder();

        if (ulica == null) {
            blad.append("Ulica nie może być nullem. ");
        }
        if (numerDomu <= 0) {
            blad.append("Numer domu musi być większy od zera. ");
        }
        if (kodPocztowy == null) {
            blad.append("Kod pocztowy nie może być nullem. ");
        }
        if (miasto == null) {
            blad.append("Miasto nie może być nullem.");
        }

        if (blad.length() > 0) {
            throw new NieprawidlowyAdresException(blad.toString().trim());
        }

        // Wszystko poprawne – przypisujemy pola
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
    }

    // Prosta metoda do wyświetlenia adresu
    public void wypiszAdres() {
        System.out.println(ulica + " " + numerDomu + ", " + kodPocztowy + " " + miasto);
    }

    // main do testowania
    public static void main(String[] args) {
        try {
            // Przykład z błędem
            Adres adres = new Adres(null, -5, null, null);
            adres.wypiszAdres();
        } catch (NieprawidlowyAdresException e) {
            System.out.println("Błąd przy tworzeniu adresu: " + e.getMessage());
        }

        try {
            // Przykład poprawny
            Adres poprawnyAdres = new Adres("Szkolna", 12, "00-001", "Warszawa");
            poprawnyAdres.wypiszAdres();
        } catch (NieprawidlowyAdresException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}

