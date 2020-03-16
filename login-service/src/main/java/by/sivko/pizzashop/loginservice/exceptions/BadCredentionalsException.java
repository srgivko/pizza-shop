package by.sivko.pizzashop.loginservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class BadCredentionalsException extends RuntimeException {

    private static final long serialVersionUID = -6008821960491464229L;
    private static final String DEFAULT_MESSAGE = "Invalid name or password";

    public BadCredentionalsException() {
        super(DEFAULT_MESSAGE);
    }

    public BadCredentionalsException(String message) {
        super(message);
    }

    public BadCredentionalsException(String message, Throwable cause) {
        super(message, cause);
    }
}
