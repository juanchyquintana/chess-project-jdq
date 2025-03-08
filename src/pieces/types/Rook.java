package pieces.types;

import board.Board;
import pieces.Piece;
import pieces.PieceController;
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
    public void insertPiece(Board board, String color) {
        Color pieceColor = getColor(color);
        int row = PieceController.setRow(color);

        board.getSquares(row, 0).setPiece(new Rook(pieceColor));
        board.getSquares(row, 7).setPiece(new Rook(pieceColor));
    }

    @Override
    public String getSymbol() {
        return color == Color.WHITE ? "♖" : "♜";
    }
}
