package pieces.types;

import pieces.Piece;
import pieces.enums.Color;
import pieces.enums.PieceType;

public class Pawn extends Piece {
    private final PieceType pieceType;

    public Pawn(Color color) {
        super(color);
        this.pieceType = PieceType.PAWN;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public boolean isValidMove(int startRow, int startColumn, int endRow, int endColumn) {
        if(color == Color.WHITE) {
            return startColumn == endColumn && endRow == startRow + 1;
        } else {
            return startColumn == endColumn && endRow == startRow - 1;
        }
    }

    @Override
    public java.lang.String getSymbol() {
        return color == Color.WHITE ? "♙" : "♟";
    }
}
