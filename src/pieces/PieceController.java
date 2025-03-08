package pieces;

import exceptions.ChessGameException;
import pieces.enums.Color;
import pieces.types.*;

/**
 * The PieceController class provides utility methods for creating chess pieces
 * and determining their initial row placement based on color.
 */
public class PieceController {
    /**
     * Creates a chess piece based on the specified type and color.
     * @param pieceType The type of the chess piece (e.g., "King", "Queen", "Bishop").
     * @param color The color of the piece ("W" for white, "B" for black).
     * @return A new instance of the specified chess piece.
     * @throws ChessGameException if the piece type is not recognized.
     */
    public static Piece createPiece(String pieceType, String color) {
        Color pieceColor = color.equalsIgnoreCase("W") ? Color.WHITE : Color.BLACK;

        return switch (pieceType.toLowerCase()) {
            case "king" -> new King(pieceColor);
            case "queen" -> new Queen(pieceColor);
            case "bishop" -> new Bishop(pieceColor);
            case "knight" -> new Knight(pieceColor);
            case "rook" -> new Rook(pieceColor);
            case "pawn" -> new Pawn(pieceColor);
            default -> throw new ChessGameException("---> Piece not recognized");
        };
    }

    /**
     * Determines the initial row position for a piece based on its color.
     * @param color The color of the piece ("W" for white, "B" for black).
     * @return The row index where the piece should be placed.
     */
    public static int setRow(String color) {
        return color.equalsIgnoreCase("W") ? 0 : 7;
    }
}
