package kg.itacademy.exam6.exceptions;

public class EmailIsNullException extends RuntimeException {
    public EmailIsNullException ( String message )
    {
        super ( message );
    }
}