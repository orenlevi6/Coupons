package exceptions;

public class MethodNotAllowedException extends Exception {
    public MethodNotAllowedException() {
        super("Method not allowed!");
    }

    public MethodNotAllowedException(String message) {
        super(message);
    }
}
