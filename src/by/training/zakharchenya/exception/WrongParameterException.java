package by.training.zakharchenya.exception;

public class WrongParameterException extends Exception {
    public WrongParameterException(){
        super("ERROR: parameter is not correct!");
    }
    public WrongParameterException(String message, Throwable exception) {
        super(message, exception);
    }
    public WrongParameterException(String message) {
        super(message);
    }
    public WrongParameterException(Throwable exception) {
        super(exception);
    }
}
