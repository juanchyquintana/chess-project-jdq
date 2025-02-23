package pieces.types;

import pieces.Piece;
import pieces.enums.Color;
import pieces.enums.PieceType;

public class King extends Piece {
    private final PieceType pieceType;

    public King(Color color) {
        super(color);
        this.pieceType = PieceType.KING;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public boolean isValidMove(int startRow, int startColumn, int endRow, int endColumn) {
        int rowDifference = Math.abs(startRow - endRow);
        int columnDifference = Math.abs(startColumn - endColumn);

        // El rey solo se mueve una casilla en cualquier direccion
        return rowDifference <= 1 && columnDifference <= 1;
    }

    @Override
    public java.lang.String getSymbol() {
        return color == Color.WHITE ? "♔" : "♚";
    }
}
