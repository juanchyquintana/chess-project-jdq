package pieces.types;

import pieces.Piece;
import pieces.enums.Color;
import pieces.enums.PieceType;

public class Bishop extends Piece {
    private final PieceType pieceType;

    public Bishop(Color color) {
        super(color);
        this.pieceType = PieceType.BISHOP;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public boolean isValidMove(int startRow, int startColumn, int endRow, int endColumn) {
        int rowDiff = Math.abs(startRow - endRow);
        int colDiff = Math.abs(startColumn - endColumn);

        return rowDiff == colDiff;
    }

    @Override
    public java.lang.String getSymbol() {
        return color == Color.WHITE ? "♗" : "♝";
    }
}
