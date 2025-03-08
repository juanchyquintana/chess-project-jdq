package pieces.types;

import board.Board;
import exceptions.ChessGameException;
import pieces.Piece;
import pieces.enums.Color;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    public void insertPiece(Board board, String color, int column) {
        Color pieceColor = getColor(color);
        int pawnRow = (pieceColor == Color.WHITE) ? 1 : 6;

        board.getSquares(pawnRow, column).setPiece(new Pawn(pieceColor));
    }

    @Override
    public void insertPiece(Board board, String color) {
        throw new ChessGameException("Use insertPiece with a column for Pawns.");
    }

    @Override
    public String getSymbol() {
        return color == Color.WHITE ? "♙" : "♟";
    }
}
