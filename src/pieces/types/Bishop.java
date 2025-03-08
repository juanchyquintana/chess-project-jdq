package pieces.types;

import board.Board;
import pieces.Piece;
import pieces.PieceController;
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
    public void insertPiece(Board board, String color) {
        Color pieceColor = getColor(color);
        int row = PieceController.setRow(color);

        board.getSquares(row, 2).setPiece(new Bishop(pieceColor));
        board.getSquares(row, 5).setPiece(new Bishop(pieceColor));
    }

    @Override
    public String getSymbol() {
        return color == Color.WHITE ? "♗" : "♝";
    }
}
