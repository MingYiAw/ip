package dude.exception;

/**
 * Thrown to indicate that no command is provided in the input.
 */
public class DudeNullCommandException extends DudeException {

    /**
     * Constructs a DudeNullCommandException with no detail message.
     */
    public DudeNullCommandException() {
        super("You did not enter anything.");
    }
}
