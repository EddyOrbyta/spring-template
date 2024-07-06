package its.esame.esame.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<String> handleUserAlreadyExistException(UserAlreadyExistException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(PasswordDoesntMatchException.class)
    public ResponseEntity<String> handlePasswordDoesntMatchException(PasswordDoesntMatchException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
