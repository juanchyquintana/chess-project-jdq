package pieces.enums;

/**
 * Represents the different types of chess pieces.
 */
public enum PieceType {
    BISHOP("Bishop"),
    KING("King"),
    KNIGHT("Knight"),
    PAWN("Pawn"),
    QUEEN("Queen"),
    ROOK("Rook");

    private final String pieceName;

    /**
     * Constructor to initialize the piece type.
     * @param pieceName The name of the chess piece.
     */
    PieceType(String pieceName) {
        this.pieceName = pieceName;
    }

    public String getPieceName() {
        return pieceName;
    }

    public String toString() {
        return pieceName;
    }
}
