package loganalizer.textinterface.resultprinters.exceptions;

public class UserCommandTypeException extends Exception {

    public UserCommandTypeException() {
    }

    public UserCommandTypeException(String msg) {
        super(msg);
    }

    public UserCommandTypeException(Throwable cause) {
        super(cause);
    }

    public UserCommandTypeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
