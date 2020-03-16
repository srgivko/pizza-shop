package by.sivko.pizzashop.loginservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotActivatedException extends RuntimeException {
    private static final long serialVersionUID = 1315626536343054835L;
    private static final String DEFAULT_MESSAGE = "That user is not activated";

    public NotActivatedException() {
        super(DEFAULT_MESSAGE);
    }

    public NotActivatedException(String message) {
        super(message);
    }

    public NotActivatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
