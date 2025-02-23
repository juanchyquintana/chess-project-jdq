package pieces.enums;

/**
 * Representa los diferentes tipos de piezas de ajedrez.
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
     * Constructor para inicializar el tipo de pieza.
     * @param pieceName El nombre de la pieza de ajedrez.
     *      Constructor to initialize the piece type.
     *      * @param pieceName The name of the chess piece.
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
