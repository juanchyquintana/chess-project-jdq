package pieces.types;

import board.Board;
import pieces.IPiece;
import pieces.Piece;
import pieces.enums.Color;
import pieces.enums.PieceType;
import pieces.piece.PieceController;

public class Pawn extends Piece implements IPiece {
    private static final int WIDTH = 8;
    private final PieceType pieceType;

    public Pawn(Color color) {
        super(color);
        this.pieceType = PieceType.PAWN;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public void insertPiece(Board board, String color) {
        System.out.println("---> MESSAGE: A PAWN is placed");

        Color pieceColor = getColor(color);
        int row = (pieceColor == Color.WHITE) ? 1 : 6;
        int emptyColumn = PieceController.findEmptyColumn(board, row);

        board.getSquares(row, emptyColumn).setPiece(new Pawn(pieceColor));
    }

    @Override
    public void insertAllPieces(Board board, String color) {
        System.out.println("---> MESSAGE: The PAWNS are placed.");

        Color pieceColor = getColor(color);
        int pawnRow = (pieceColor == Color.WHITE) ? 1 : 6;

        for (int i = 0; i < WIDTH; i++) {
            board.getSquares(pawnRow, i).setPiece(new Pawn(pieceColor));
        }
    }

    @Override
    public boolean isValidMove(int startRow, int startColumn, int endRow, int endColumn) {
        if(color == Color.WHITE) {
            return startColumn == endColumn && endRow == startRow + 1;
        } else {
            return startColumn == endColumn && endRow == startRow - 1;
        }
    }

    @Override
    public java.lang.String getSymbol() {
        return color == Color.WHITE ? "♙" : "♟";
    }
}
