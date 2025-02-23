package pieces;

import board.Board;
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
            System.out.println("Opción No Válida.");
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
                insertPawns(color);
                break;
            case 16:
                insertFullSetPieces(color);
                break;
            default:
                System.out.println("Opción No Válida.");
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
                insertPawns(color);
                break;
            default:
                System.out.println("Opción No Válida.");
        }

    }

    public void insertKing(String color) {
        System.out.println("---> MESSAGE: Se coloca al Rey");
        board.getSquares(getRow(color), 4).setPiece(new King(getColor(color)));
    }

    public void insertQueen(String color) {
        System.out.println("---> MESSAGE: Se coloca a la Reina");
        board.getSquares(getRow(color), 3).setPiece(new Queen(getColor(color)));
    }

    public void insertBishops(String color) {
        System.out.println("---> MESSAGE: Se colocan los Alfiles");

        board.getSquares(getRow(color), 2).setPiece(new Bishop(getColor(color)));
        board.getSquares(getRow(color), 5).setPiece(new Bishop(getColor(color)));
    }

    public void insertKnights(String color) {
        System.out.println("---> MESSAGE: Se colocan las Caballos");

        board.getSquares(getRow(color), 1).setPiece(new Knight(getColor(color)));
        board.getSquares(getRow(color), 6).setPiece(new Knight(getColor(color)));
    }

    public void insertRooks(String color) {
        System.out.println("---> MESSAGE: Se colocan las Torres");

        board.getSquares(getRow(color), 0).setPiece(new Rook(getColor(color)));
        board.getSquares(getRow(color), 7).setPiece(new Rook(getColor(color)));
    }

    public void insertPawns(String color) {
        System.out.println("---> MESSAGE: Se colocan los peones");
        Color pieceColor = getColor(color);
        int pawnRow = (pieceColor == Color.WHITE) ? 1 : 6;

        for (int i = 0; i < WIDTH; i++) {
            board.getSquares(pawnRow, i).setPiece(new Pawn(pieceColor));
        }
    }

    public void insertFullSetPieces(String color) {
        System.out.println("---> MESSAGE: Se colocan todas las piezas");

        insertKing(color);
        insertQueen(color);
        insertBishops(color);
        insertKnights(color);
        insertRooks(color);
        insertPawns(color);
    }

    private static Color getColor(String color) {
        return color.equalsIgnoreCase("W") ? Color.WHITE : Color.BLACK;
    }

    private static int getRow(String color) {
        return color.equalsIgnoreCase("W") ? 0 : 7;
    }
}
