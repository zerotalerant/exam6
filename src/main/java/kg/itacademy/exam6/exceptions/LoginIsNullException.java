package kg.itacademy.exam6.exceptions;

public class LoginIsNullException extends RuntimeException {
    public LoginIsNullException (String message)
    {
        super ( message );
    }
}
