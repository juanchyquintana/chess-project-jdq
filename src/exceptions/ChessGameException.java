package exceptions;

/**
 * Excepción personalizada para manejar errores relacionados con el ajedrez.
 * Custom exception for handling chess-related errors.
 */
public class ChessGameException extends RuntimeException {
    public ChessGameException(String message, Throwable cause) {
        super(message, cause);
    }
}
