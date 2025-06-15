package LibraryManagementSystem;
public class Book {
    // Pola: tytuł, autor, ISBN
    private String title;
    private String author;
    private String isbn;
    // Konstruktor z walidacją danych (rzuca wyjątek)
    public Book(String title, String author, String isbn) throws
            InvalidBookException {
        // ustawienie pól z walidacją
    }
    // Gettery i settery z walidacją
    public String getTitle() { /* ... */
        return "";
    }
    public void setTitle(String title) throws InvalidBookException { /*
walidacja */ }
    public String getAuthor() { /* ... */
        return "";
    }
    public void setAuthor(String author) throws InvalidBookException { /*
walidacja */ }
    public String getIsbn() { /* ... */
        return "";
    }
    public void setIsbn(String isbn) throws InvalidBookException { /*
walidacja */ }
    // toString() do wyświetlania książki
}