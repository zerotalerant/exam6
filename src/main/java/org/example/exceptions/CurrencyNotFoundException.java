package org.example.exceptions;

public class CurrencyNotFoundException extends RuntimeException {
    public CurrencyNotFoundException ( String message )
    {
        super ( message );
    }
}
