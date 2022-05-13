package kg.itacademy.exam6.exceptions;

public class LoginNotFoundException extends RuntimeException {
    public LoginNotFoundException ( String message )
    {
        super ( message );
    }
}