package loganalizer.exceptions;

public class IntCommandFormatException extends Exception {

    public IntCommandFormatException() {
    }

    public IntCommandFormatException(String msg) {
        super(msg);
    }

    public IntCommandFormatException(Throwable cause) {
        super(cause);
    }

    public IntCommandFormatException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
