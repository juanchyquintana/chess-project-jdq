package pieces.types;

import board.Board;
import pieces.Piece;
import pieces.PieceController;
import pieces.enums.Color;
import pieces.enums.PieceType;

public class Queen extends Piece {
    private final PieceType pieceType;

    public Queen(Color color) {
        super(color);
        this.pieceType = PieceType.QUEEN;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public void insertPiece(Board board, String color, int column) {
        Color pieceColor = getColor(color);
        int row = PieceController.setRow(color);

        board.getSquares(row, column).setPiece(new Queen(pieceColor));
    }

    @Override
    public String getSymbol() {
        return color == Color.WHITE ? "♕" : "♛";
    }
}
