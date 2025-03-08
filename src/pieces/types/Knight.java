package pieces.types;

import board.Board;
import pieces.Piece;
import pieces.PieceController;
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
    public void insertPiece(Board board, String color) {
        Color pieceColor = getColor(color);
        int row = PieceController.setRow(color);

        board.getSquares(row, 1).setPiece(new Knight(pieceColor));
        board.getSquares(row, 6).setPiece(new Knight(pieceColor));
    }

    @Override
    public String getSymbol() {
        return color == Color.WHITE ? "♘" : "♞";
    }
}
