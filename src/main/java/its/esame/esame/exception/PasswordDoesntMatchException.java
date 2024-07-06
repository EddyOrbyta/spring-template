package its.esame.esame.exception;

public class PasswordDoesntMatchException extends Throwable {
    public PasswordDoesntMatchException(String msg) {
        super(msg);
    }
}
