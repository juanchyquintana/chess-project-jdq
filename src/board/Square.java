package board;

import pieces.Piece;

/**
 * Representa una sola casilla en el tablero de ajedrez.
 * Cada casilla tiene un índice de fila y columna y puede contener una pieza.
 *
 * Represents a single square on the chessboard.
 * Each square has a row and column index and can contain a piece.
 */
public class Square {
    private final int row;
    private final int column;
    private Piece piece;

    /**
     * Constructor para crear un cuadrado en el tablero.
     * @param row El índice de fila del cuadrado.
     * @param column El índice de columna del cuadrado.
     * @param piece La pieza de ajedrez colocada en el cuadrado, o null si está vacío.
     *  Constructor to create a square on the board.
     *      * @param row The row index of the square.
     *      * @param column The column index of the square.
     *      * @param piece The chess piece placed on the square, or null if empty.
     */
    public Square(int row, int column, Piece piece) {
        this.column = column;
        this.row = row;
        this.piece = piece;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
