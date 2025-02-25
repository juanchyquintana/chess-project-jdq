package pieces;

import board.Board;

public interface IPiece {
    void insertPiece(Board board, String color);

    void insertAllPieces(Board board, String color);
}
