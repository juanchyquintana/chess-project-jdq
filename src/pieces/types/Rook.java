package pieces.types;

import board.Board;
import pieces.IPiece;
import pieces.Piece;
import pieces.enums.Color;
import pieces.enums.PieceType;
import pieces.piece.PieceController;

public class Rook extends Piece implements IPiece {
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
        System.out.println("---> MESSAGE: The ROOK is placed");

        Color pieceColor = getColor(color);
        int row = PieceController.getRow(color);
        int emptyColumn = PieceController.findEmptyColumn(board, row);

        board.getSquares(row, emptyColumn).setPiece(new Rook(pieceColor));
    }

    @Override
    public void insertAllPieces(Board board, String color) {
        System.out.println("---> MESSAGE: The ROOKS are placed");

        board.getSquares(PieceController.getRow(color), 0).setPiece(new Rook(getColor(color)));
        board.getSquares(PieceController.getRow(color), 7).setPiece(new Rook(getColor(color)));
    }

    @Override
    public boolean isValidMove(int startRow, int startColumn, int endRow, int endColumn) {
        return startRow == endRow || startColumn == endColumn;
    }

    @Override
    public java.lang.String getSymbol() {
        return color == Color.WHITE ? "♖" : "♜";
    }
}
