package kg.itacademy.exam6.exceptions;

public class PasswordIsNullException extends RuntimeException{
    public PasswordIsNullException (String message){
        super ( message );
    }
}
