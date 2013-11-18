package loganalizer.exceptions;

public class ParseException extends Exception {

    public ParseException() {
    }

    public ParseException(String msg) {
        super(msg);
    }

    public ParseException(Throwable cause) {
        super(cause);
    }

    public ParseException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
