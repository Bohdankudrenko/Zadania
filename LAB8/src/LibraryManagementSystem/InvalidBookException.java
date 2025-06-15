package LibraryManagementSystem;
// Własny wyjątek dla błędów walidacji książki
public class InvalidBookException extends Exception {
    public InvalidBookException(String message) {
        super(message);
    }
}
