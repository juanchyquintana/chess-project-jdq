package pieces;

import board.Board;
import exceptions.ChessGameException;
import pieces.enums.Color;
import pieces.types.*;

public class PieceController {
    private static final int WIDTH = 8;
    private Board board;

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
                insertKing(color);
                break;
            case 2:
                insertKing(color);
                insertQueen(color);
                break;
            case 4:
                insertKing(color);
                insertQueen(color);
                insertBishops(color);
                break;
            case 6:
                insertKing(color);
                insertQueen(color);
                insertBishops(color);
                insertKnights(color);
                break;
            case 8:
                insertKing(color);
                insertQueen(color);
                insertBishops(color);
                insertKnights(color);
                insertRooks(color);
                break;
            case 10:
                insertPawn(color);
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
                insertKing(color);
                break;
            case "q":
                insertQueen(color);
                break;
            case "b":
                insertBishops(color);
                break;
            case "h":
                insertKnights(color);
                break;
            case "r":
                insertRooks(color);
                break;
            case "p":
                insertPawn(color);
                break;
            default:
                throw new ChessGameException("Option not valid.");
        }

    }



    public void insertKing(String color) {
        System.out.println("---> MESSAGE: The KING is placed");

        Color pieceColor = getColor(color);
        int row = getRow(color);
        int emptyColumn = findEmptyColumn(row);

        board.getSquares(row, emptyColumn).setPiece(new King(pieceColor));
    }

    public void insertQueen(String color) {
        System.out.println("---> MESSAGE: The QUEEN is placed");

        Color pieceColor = getColor(color);
        int row = getRow(color);
        int emptyColumn = findEmptyColumn(row);

        board.getSquares(row, emptyColumn).setPiece(new Queen(pieceColor));
    }

    public void insertPawn(String color) {
        System.out.println("---> MESSAGE: A PAWN is placed");

        Color pieceColor = getColor(color);
        int row = (pieceColor == Color.WHITE) ? 1 : 6;
        int emptyColumn = findEmptyColumn(row);

        board.getSquares(row, emptyColumn).setPiece(new Pawn(pieceColor));
    }

    public void insertRooks(String color) {
        System.out.println("---> MESSAGE: The ROOK is placed");

        Color pieceColor = getColor(color);
        int row = getRow(color);
        int emptyColumn = findEmptyColumn(row);

        board.getSquares(row, emptyColumn).setPiece(new Rook(pieceColor));
    }

    public void insertBishops(String color) {
        System.out.println("---> MESSAGE: The BISHOP is placed");

        Color pieceColor = getColor(color);
        int row = getRow(color);
        int emptyColumn = findEmptyColumn(row);

        board.getSquares(row, emptyColumn).setPiece(new Bishop(pieceColor));
    }

    public void insertKnights(String color) {
        System.out.println("---> MESSAGE: The HORSE is placed");

        Color pieceColor = getColor(color);
        int row = getRow(color);
        int emptyColumn = findEmptyColumn(row);

        board.getSquares(row, emptyColumn).setPiece(new Knight(pieceColor));
    }



    public void insertAllBishops(String color) {
        System.out.println("---> MESSAGE: The BISHOPS are placed");

        board.getSquares(getRow(color), 2).setPiece(new Bishop(getColor(color)));
        board.getSquares(getRow(color), 5).setPiece(new Bishop(getColor(color)));
    }

    public void insertAllKnights(String color) {
        System.out.println("---> MESSAGE: The HORSES are placed");

        board.getSquares(getRow(color), 1).setPiece(new Knight(getColor(color)));
        board.getSquares(getRow(color), 6).setPiece(new Knight(getColor(color)));
    }

    public void insertAllRooks(String color) {
        System.out.println("---> MESSAGE: The ROOKS are placed");

        board.getSquares(getRow(color), 0).setPiece(new Rook(getColor(color)));
        board.getSquares(getRow(color), 7).setPiece(new Rook(getColor(color)));
    }

    public void insertAllPawns(String color) {
        System.out.println("---> MESSAGE: The PAWNS are placed.");
        Color pieceColor = getColor(color);
        int pawnRow = (pieceColor == Color.WHITE) ? 1 : 6;

        for (int i = 0; i < WIDTH; i++) {
            board.getSquares(pawnRow, i).setPiece(new Pawn(pieceColor));
        }
    }

    public void insertFullSetPieces(String color) {
        System.out.println("---> MESSAGE: All PARTS are placed");

        insertKing(color);
        insertQueen(color);
        insertAllBishops(color);
        insertAllKnights(color);
        insertAllRooks(color);
        insertAllPawns(color);
    }



    private static Color getColor(String color) {
        return color.equalsIgnoreCase("W") ? Color.WHITE : Color.BLACK;
    }

    private static int getRow(String color) {
        return color.equalsIgnoreCase("W") ? 0 : 7;
    }

    private int findEmptyColumn(int row) {
        // Find the first empty column in the pawn row
        for (int col = 0; col < WIDTH; col++) {
            if (board.getSquares(row, col).getPiece() == null) {
                System.out.println("---> DEBUG: Empty column found at " + col);
                return col;
            }
        }

        // If there is no space, throw error
        throw new ChessGameException("---> MESSAGE: No more pieces can be added.");
    }
}
