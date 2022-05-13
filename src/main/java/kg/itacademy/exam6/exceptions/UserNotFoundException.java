package kg.itacademy.exam6.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException ( String message )
    {
        super ( message );
    }
}
