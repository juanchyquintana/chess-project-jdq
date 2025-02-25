package pieces.types;

import board.Board;
import pieces.IPiece;
import pieces.Piece;
import pieces.enums.Color;
import pieces.enums.PieceType;
import pieces.piece.PieceController;


public class King extends Piece implements IPiece {
    private final PieceType pieceType;

    public King(Color color) {
        super(color);
        this.pieceType = PieceType.KING;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public void insertPiece(Board board, String color) {
        System.out.println("---> MESSAGE: The KING is placed");

        Color pieceColor = getColor(color);
        int row = PieceController.getRow(color);
        int emptyColumn = PieceController.findEmptyColumn(board, row);

        board.getSquares(row, emptyColumn).setPiece(new King(pieceColor));
    }

    @Override
    public void insertAllPieces(Board board, String color) {
        Color pieceColor = getColor(color);
        int row = PieceController.getRow(color);

        board.getSquares(row, 4).setPiece(new Queen(pieceColor));
    }

    @Override
    public boolean isValidMove(int startRow, int startColumn, int endRow, int endColumn) {
        int rowDifference = Math.abs(startRow - endRow);
        int columnDifference = Math.abs(startColumn - endColumn);

        // El rey solo se mueve una casilla en cualquier direccion
        return rowDifference <= 1 && columnDifference <= 1;
    }

    @Override
    public java.lang.String getSymbol() {
        return color == Color.WHITE ? "♔" : "♚";
    }
}
