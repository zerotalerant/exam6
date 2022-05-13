package kg.itacademy.exam6.exceptions;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException (String message) {
        super(message);
    }
}
