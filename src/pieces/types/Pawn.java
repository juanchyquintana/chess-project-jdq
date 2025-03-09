package pieces.types;

import board.Board;
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
    public void insertPiece(Board board, String color, int column) {
        Color pieceColor = getColor(color);
        int pawnRow = (pieceColor == Color.WHITE) ? 1 : 6;

        board.getSquares(pawnRow, column).setPiece(new Pawn(pieceColor));
    }

    @Override
    public String getSymbol() {
        return color == Color.WHITE ? "♙" : "♟";
    }
}
