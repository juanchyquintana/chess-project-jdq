package moveSorting.sorts;

import board.Board;
import game.ChessGameController;
import moveSorting.AlgorithmMoveController;
import moveSorting.IAlgorithmMove;
import parameters.ChessParams;

import java.util.List;

/**
 * Implements the Insertion Sort algorithm for sorting chess piece values.
 * This algorithm builds a sorted portion of the list by inserting each element
 * into its correct position relative to the already sorted section.
 */
public class InsertionSort implements IAlgorithmMove {
    @Override
    public void sort(List<Integer> values, Board board, ChessParams chessParams, AlgorithmMoveController algorithmMoveController) {
        ChessGameController controller = new ChessGameController();

        int quantityValues = values.size();
        for (int i = 0; i < quantityValues; i++) {
            int key = values.get(i);
            int j = i - 1;

            while (j >= 0 && values.get(j) > key) {
                values.set(j + 1, values.get(j));
                j--;
            }
            values.set(j + 1, key);

            List<String> formattedValues = controller.formatInitialValues(values, chessParams.getListType());
            System.out.println("Iteration " + (i + 1) + ": " + formattedValues);

            board.updateBoard(values, chessParams, i);
            algorithmMoveController.printAndPause(chessParams.getSpeed());
        }
    }
}
