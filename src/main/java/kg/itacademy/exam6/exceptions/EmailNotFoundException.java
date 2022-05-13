package kg.itacademy.exam6.exceptions;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException (String message)
    {
        super ( message );
    }
}
