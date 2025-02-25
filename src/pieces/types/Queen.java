package pieces.types;

import board.Board;
import pieces.IPiece;
import pieces.Piece;
import pieces.enums.Color;
import pieces.enums.PieceType;
import pieces.piece.PieceController;

public class Queen extends Piece implements IPiece {
    private final PieceType pieceType;

    public Queen(Color color) {
        super(color);
        this.pieceType = PieceType.QUEEN;
    }

    @Override
    public void insertPiece(Board board, String color) {
        System.out.println("---> MESSAGE: The QUEEN is placed");

        Color pieceColor = getColor(color);
        int row = PieceController.getRow(color);
        int emptyColumn = PieceController.findEmptyColumn(board, row);

        board.getSquares(row, emptyColumn).setPiece(new Queen(pieceColor));
    }

    @Override
    public void insertAllPieces(Board board, String color) {
        Color pieceColor = getColor(color);
        int row = PieceController.getRow(color);

        board.getSquares(row, 3).setPiece(new Queen(pieceColor));
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public boolean isValidMove(int startRow, int startColumn, int endRow, int endColumn) {
        int rowDiff = Math.abs(startRow - endRow);
        int colDiff = Math.abs(startColumn - endColumn);

        return startRow == endRow || startColumn == endColumn || rowDiff == colDiff;
    }

    @Override
    public java.lang.String getSymbol() {
        return color == Color.WHITE ? "♕" : "♛";
    }
}
