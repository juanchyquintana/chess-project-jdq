package board;

import exceptions.ChessGameException;
import parameters.ChessParams;
import pieces.Piece;
import pieces.PieceController;
import pieces.types.*;

import java.util.List;

/**
 * Represents a single square on the chessboard.
 * Each square has a row and column index and can contain a piece.
 */
public class Board {
    private static final int HEIGHT = 8;
    private static final int WIDTH = 8;
    private final Square[][] board;

    /**
     * Constructor that initializes the board by creating empty squares.
     */
    public Board() {
        this.board = new Square[HEIGHT][WIDTH];
    }

    /**
     * Initializes the chessboard by creating empty squares.
     * @throws ChessGameException if an error occurs during board creation.
     */
    public void createBoard() {
        try {
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    board[i][j] = new Square(i, j, null); // volver a poner el null al final
                }
            }
        } catch (Exception e) {
            throw new ChessGameException("---> MESSAGE: Error creating board", e);
        }
    }

    /**
     * Prints the current state of the board, displaying piece symbols or empty squares.
     * @throws ChessGameException if an error occurs while printing the board.
     */
    public void printBoard() {
        try {
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    Piece piece = board[i][j].getPiece();
                    System.out.print(piece != null ? piece.getSymbol() + " " : " *");
                }
                System.out.println();
            }
            System.out.println();
        } catch (Exception e) {
            throw new ChessGameException("---> MESSAGE: Error printing board", e);
        }
    }

    /**
     * Updates the board by placing chess pieces in their final positions.
     * @param values List of integer values representing chess pieces.
     * @param params The game parameters including piece color.
     * @param step The number of steps to process.
     */
    public void updateBoard(List<Integer> values, ChessParams params, int step) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = new Square(row, col, null);
            }
        }

        int maxIterations = Math.min(step, values.size() - 1);
        for (int i = 0; i <= maxIterations; i++) {
            int value = values.get(i) - 1;
            if (value < 0 || value >= 16) continue;

            String pieceName = getPieceName(value);
            Piece piece = PieceController.createPiece(pieceName, params.getColor());

            insertPieces(piece, params, value);
        }
        printBoard();
    }

    /**
     * Inserts a chess piece into the board based on its type and predefined column position.
     * Each piece has a specific starting position on the board.
     * @param piece  The chess piece to be inserted.
     * @param params The chess game parameters, including piece color.
     * @param value  The numeric value representing the piece in the game's list.
     */
    private void insertPieces(Piece piece, ChessParams params, int value) {
        if (piece instanceof Pawn pawn) {
            pawn.insertPiece(this, params.getColor(), value - 8);
        } else if (piece instanceof Bishop bishop) {
            bishop.insertPiece(this, params.getColor(), value == 2 ? 2 : 5);
        } else if (piece instanceof Knight knight) {
            knight.insertPiece(this, params.getColor(), value == 4 ? 1 : 6);
        } else if (piece instanceof Rook rook) {
            rook.insertPiece(this, params.getColor(), value == 6 ? 0 : 7);
        } else if (piece instanceof Queen queen) {
            queen.insertPiece(this, params.getColor(), 3);  // La reina siempre en columna 3
        } else if (piece instanceof King king) {
            king.insertPiece(this, params.getColor(), 4);  // El rey siempre en columna 4
        }
    }

    /**
     * Retrieves the name of a chess piece based on its numeric value (1-16).
     * @param value The numeric value of the piece.
     * @return The name of the corresponding chess piece.
     */
    private String getPieceName(int value) {
        List<String> pieces = List.of(
                "King", "Queen", "Bishop", "Bishop", "Knight", "Knight", "Rook", "Rook",
                "Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn"
        );

        if (value >= 0 && value < pieces.size()) {
            return pieces.get(value);
        } else {
            throw new ChessGameException("---> Invalid piece value: " + value);
        }
    }

    /**
     * Retrieves a specific square from the board based on row and column indices.
     * @param row    The row index of the square.
     * @param column The column index of the square.
     * @return The corresponding Square object.
     */
    public Square getSquares(int row, int column) {
        return board[row][column];
    }
}