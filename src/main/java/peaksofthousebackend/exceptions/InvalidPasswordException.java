package peaksofthousebackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidPasswordException extends AuthenticationException {

    public InvalidPasswordException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InvalidPasswordException(String msg) {
        super(msg);
    }
}
