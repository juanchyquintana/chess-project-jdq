package board;


import pieces.Piece;

/**
 * Represents a single square on the chessboard.
 * Each square has a row and column index and can contain a piece.
 */
public class Square {
    private final int row;
    private final int column;
    private Piece piece;

    /**
     *  Constructor to create a square on the board.
     *  @param row The row index of the square.
     *  @param column The column index of the square.
     */
    public Square(int row, int column, Piece piece) {
        this.column = column;
        this.row = row;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
