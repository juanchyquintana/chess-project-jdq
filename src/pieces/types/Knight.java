package pieces.types;

import pieces.Piece;
import pieces.enums.Color;
import pieces.enums.PieceType;

public class Knight extends Piece {
    private final PieceType pieceType;

    public Knight(Color color) {
        super(color);
        this.pieceType = PieceType.KNIGHT;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public boolean isValidMove(int startRow, int startColumn, int endRow, int endColumn) {
        int rowDiff = Math.abs(startRow - endRow);
        int colDiff = Math.abs(startColumn - endColumn);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }

    @Override
    public java.lang.String getSymbol() {
        return color == Color.WHITE ? "♘" : "♞";
    }
}
