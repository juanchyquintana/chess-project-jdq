package pieces.piece;

import board.Board;
import exceptions.ChessGameException;
import pieces.IPiece;
import pieces.enums.Color;

public class PieceController {
    private static final int WIDTH = 8;
    private Board board;
    private IPiece piece;

    public PieceController(Board board) {
        this.board = board;
    }

    public void insertPieces(Object value, String color) {
        if (value instanceof Integer) {
            insertByNumber((Integer) value, color);
        } else if (value instanceof String) {
            insertByCharacter((String) value, color);
        } else {
            System.out.println("Option not valid.");
        }
    }

    private void insertByNumber(int numberPiece, String color) {
        switch (numberPiece) {
            case 1:
                piece = PieceFactory.createPiece("king", getColor(color));
                insertPiece(piece, color);
                break;
            case 2:
                piece = PieceFactory.createPiece("queen", getColor(color));
                insertPiece(piece, color);
                break;
            case 4:
                piece = PieceFactory.createPiece("bishop", getColor(color));
                insertPiece(piece, color);
                break;
            case 6:
                piece = PieceFactory.createPiece("knight", getColor(color));
                insertPiece(piece, color);
                break;
            case 8:
                piece = PieceFactory.createPiece("rook", getColor(color));
                insertPiece(piece, color);
                break;
            case 10:
                piece = PieceFactory.createPiece("pawn", getColor(color));
                insertPiece(piece, color);
                break;
            case 16:
                insertFullSetPieces(color);
                break;
            default:
                System.out.println("Option not valid.");
        }
    }

    private void insertByCharacter(String characterPiece, String color) {
        switch (characterPiece) {
            case "k":
                piece = PieceFactory.createPiece("king", getColor(color));
                insertPiece(piece, color);
                break;
            case "q":
                piece = PieceFactory.createPiece("queen", getColor(color));
                insertPiece(piece, color);
                break;
            case "b":
                piece = PieceFactory.createPiece("bishop", getColor(color));
                insertPiece(piece, color);
                break;
            case "h":
                piece = PieceFactory.createPiece("knight", getColor(color));
                insertPiece(piece, color);
                break;
            case "r":
                piece = PieceFactory.createPiece("rook", getColor(color));
                insertPiece(piece, color);
                break;
            case "p":
                piece = PieceFactory.createPiece("pawn", getColor(color));
                insertPiece(piece, color);
                break;
            default:
                throw new ChessGameException("Option not valid.");
        }

    }

    private void insertPiece(IPiece piece, String color) {
        piece.insertPiece(board, color);
    }

    private void insertAllPieces(IPiece piece, String color) {
        piece.insertAllPieces(board, color);
    }

    public void insertFullSetPieces(String color) {
        System.out.println("---> MESSAGE: All Pieces are placed");

        insertAllPieces(PieceFactory.createPiece("king", getColor(color)), color);
        insertAllPieces(PieceFactory.createPiece("queen", getColor(color)), color);
        insertAllPieces(PieceFactory.createPiece("bishop", getColor(color)), color);
        insertAllPieces(PieceFactory.createPiece("knight", getColor(color)), color);
        insertAllPieces(PieceFactory.createPiece("rook", getColor(color)), color);
        insertAllPieces(PieceFactory.createPiece("pawn", getColor(color)), color);
    }

    public Color getColor(String color) {
        return color.equalsIgnoreCase("W") ? Color.WHITE : Color.BLACK;
    }

    public static int getRow(String color) {
        return color.equalsIgnoreCase("W") ? 0 : 7;
    }

    public static int findEmptyColumn(Board board, int row) {
        // Find the first empty column in the pawn row
        for (int col = 0; col < WIDTH; col++) {
            if (board.getSquares(row, col).getPiece() == null) {
                return col;
            }
        }

        // If there is no space, throw error
        throw new ChessGameException("---> MESSAGE: No more pieces can be added.");
    }
}
