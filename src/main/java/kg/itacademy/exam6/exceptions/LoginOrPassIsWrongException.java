package kg.itacademy.exam6.exceptions;

import org.springframework.http.HttpStatus;

public class LoginOrPassIsWrongException extends RuntimeException {
    public LoginOrPassIsWrongException ( String message, HttpStatus unauthorized ) {
        super(message);
    }
}
