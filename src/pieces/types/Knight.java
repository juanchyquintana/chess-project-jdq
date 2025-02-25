package pieces.types;

import board.Board;
import pieces.IPiece;
import pieces.Piece;
import pieces.enums.Color;
import pieces.enums.PieceType;
import pieces.piece.PieceController;

public class Knight extends Piece implements IPiece {
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
        System.out.println("---> MESSAGE: The HORSE is placed");

        Color pieceColor = getColor(color);
        int row = PieceController.getRow(color);
        int emptyColumn = PieceController.findEmptyColumn(board, row);

        board.getSquares(row, emptyColumn).setPiece(new Knight(pieceColor));
    }

    @Override
    public void insertAllPieces(Board board, String color) {
        System.out.println("---> MESSAGE: The HORSES are placed");

        board.getSquares(PieceController.getRow(color), 1).setPiece(new Knight(getColor(color)));
        board.getSquares(PieceController.getRow(color), 6).setPiece(new Knight(getColor(color)));
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
