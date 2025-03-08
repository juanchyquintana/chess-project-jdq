package moveSorting;

import board.Board;
import parameters.ChessParams;

import java.util.List;

public interface IAlgorithmMove {
    void sort(List<Integer> values, Board board, ChessParams chessParams, AlgorithmMoveController algorithmMoveController);
}
