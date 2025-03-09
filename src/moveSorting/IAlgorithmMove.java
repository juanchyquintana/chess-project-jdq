package moveSorting;

import board.Board;
import parameters.ChessParams;

import java.util.List;

/**
 * Represents a sorting algorithm for chess piece movements.
 * Implementing classes must define the sorting logic used to arrange
 * chess pieces based on the specified game parameters.
 */
public interface IAlgorithmMove {
    /**
     * Sorts the given list of piece values according to the selected algorithm.
     * @param values The list of numerical values representing chess pieces.
     * @param board The chessboard where the sorting process is visualized.
     * @param chessParams Configuration parameters for the sorting process (e.g., type of list, speed).
     * @param algorithmMoveController Controller responsible for executing the sorting algorithm.
     */
    void sort(List<Integer> values, Board board, ChessParams chessParams, AlgorithmMoveController algorithmMoveController);
}
