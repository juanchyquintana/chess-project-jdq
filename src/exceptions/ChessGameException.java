package exceptions;

/**
 * Custom exception for handling chess-related errors.
 */
public class ChessGameException extends RuntimeException {

    public ChessGameException(String message) {
        super(message);
    }

    public ChessGameException(String message, Throwable cause) {
        super(message, cause);
    }
}
