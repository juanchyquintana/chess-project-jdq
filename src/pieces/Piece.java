package pieces;

import board.Board;
import exceptions.ChessGameException;
import pieces.enums.Color;

/**
 * The Piece class is an abstract representation of a chess piece.
 * Each piece has a color, a value, and specific behavior for insertion on the board.
 * This class also implements Comparable<Piece> to allow sorting based on values.
 */
public abstract class Piece implements Comparable<Piece> {
    protected Color color;
    protected Object value; // Can be an Integer or String depending on game mode

    /**
     * Constructs a new chess piece with the specified color.
     * @param color The color of the piece (WHITE or BLACK).
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * Returns the symbol representing the piece (e.g., "K" for King, "Q" for Queen).
     * @return A string representing the piece's symbol.
     */
    public abstract String getSymbol();

    /**
     * Inserts the piece into the given board at a specified position.
     * @param board The chessboard where the piece will be placed.
     * @param color The color of the piece.
     */
    public abstract void insertPiece(Board board, String color);

    /**
     * Determines the piece color based on a string input.
     * @param color A string representing the color ("W" for White, "B" for Black).
     * @return The corresponding @code Color enum.
     */
    public Color getColor(String color) {
        return color.equalsIgnoreCase("W") ? Color.WHITE : Color.BLACK;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int compareTo (Piece other) {
        if (this.value instanceof Integer && other.value instanceof Integer) {
            return ((Integer) this.value).compareTo((Integer) other.value);
        } else if (this.value instanceof String && other.value instanceof String) {
            return ((String) this.value).compareTo((String) other.value);
        } else {
            throw new ChessGameException("Cannot compare different types of values");
        }
    }
}
