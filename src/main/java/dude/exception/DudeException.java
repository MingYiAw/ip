package dude.exception;

public class DudeException extends Exception {
    public DudeException(String s) {
        super("Oops!! " + s);
    }
}
