package board;

import exceptions.ChessGameException;
import pieces.Piece;

/**
 * Representa un tablero de ajedrez con un tamaño fijo de 8x8 casillas.
 * Proporciona métodos para inicializar, imprimir y acceder a las casillas del tablero.
 * Represents a chessboard with a fixed size of 8x8 squares.
 * It provides methods to initialize, print, and access squares on the board.
 */
public class Board {
    private static final int HEIGHT = 8;
    private static final int WIDTH = 8;
    private final Square[][] board;

    /**
     * Constructor que inicializa el tablero creando casillas vacías.
     * Constructor that initializes the board by creating empty squares.
     */
    public Board() {
        this.board = new Square[HEIGHT][WIDTH];
    }

    /**
     * Inicializa el tablero creando casillas vacías.
     * Initializes the board by creating empty squares.
     */
    public void createBoard() {
        try {
            for(int i = 0; i < HEIGHT; i++) {
                for(int j = 0; j < WIDTH; j++) {
                    board[i][j] = new Square(i, j, null);
                }
            }
        } catch (Exception e) {
            throw new ChessGameException("---> MESSAGE: Error creating board",e);
        }
    }

    /**
     * Imprime el estado actual del tablero.
     * Prints the current state of the board.
     */
    public void printBoard() {
        try {
            for(int i = 0; i < HEIGHT; i++) {
                for(int j = 0; j < WIDTH; j++) {
                    Piece piece = board[i][j].getPiece();
                    System.out.print(piece != null ? piece.getSymbol() + " " : " *");
                }
                System.out.println();
            }
        } catch (Exception e) {
            throw new ChessGameException("---> MESSAGE: Error printing board", e);
        }
    }

    /**
     * Recupera un cuadrado específico del tablero basándose en los índices de fila y columna.
     * @param row El índice de fila del cuadrado.
     * @param column El índice de columna del cuadrado.
     * @return El objeto cuadrado correspondiente.
     *
     * Retrieves a specific square from the board based on row and column indices.
     *      * @param row The row index of the square.
     *      * @param column The column index of the square.
     *      * @return The corresponding Square object.
     */
    public Square getSquares(int row, int column) {
        return board[row][column];
    }
}
