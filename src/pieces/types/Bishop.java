package pieces.types;

import board.Board;
import pieces.IPiece;
import pieces.Piece;
import pieces.enums.Color;
import pieces.enums.PieceType;
import pieces.piece.PieceController;

public class Bishop extends Piece implements IPiece {
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
        System.out.println("---> MESSAGE: The BISHOP is placed");

        Color pieceColor = getColor(color);
        int row = PieceController.getRow(color);
        int emptyColumn = PieceController.findEmptyColumn(board, row);

        board.getSquares(row, emptyColumn).setPiece(new Bishop(pieceColor));
    }

    @Override
    public void insertAllPieces(Board board, String color) {
        System.out.println("---> MESSAGE: The BISHOPS are placed");

        board.getSquares(PieceController.getRow(color), 2).setPiece(new Bishop(getColor(color)));
        board.getSquares(PieceController.getRow(color), 5).setPiece(new Bishop(getColor(color)));
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
