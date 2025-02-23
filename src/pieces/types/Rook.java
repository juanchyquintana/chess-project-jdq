package pieces.types;

import pieces.Piece;
import pieces.enums.Color;
import pieces.enums.PieceType;

public class Rook extends Piece {
    private final PieceType pieceType;

    public Rook(Color color) {
        super(color);
        this.pieceType = PieceType.ROOK;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public boolean isValidMove(int startRow, int startColumn, int endRow, int endColumn) {
        return startRow == endRow || startColumn == endColumn;
    }

    @Override
    public java.lang.String getSymbol() {
        return color == Color.WHITE ? "♖" : "♜";
    }
}
