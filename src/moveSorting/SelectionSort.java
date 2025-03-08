package moveSorting;

import board.Board;
import game.ChessGameController;
import parameters.ChessParams;

import java.util.List;

/**
 * Implements the Selection Sort algorithm for sorting chess piece values.
 * This algorithm repeatedly finds the smallest element in the unsorted portion of the list
 * and swaps it with the first unsorted element.
 */
public class SelectionSort implements IAlgorithmMove {
    @Override
    public void sort(List<Integer> values, Board board, ChessParams chessParams, AlgorithmMoveController algorithmMoveController) {
        ChessGameController controller = new ChessGameController();

        int n = values.size();
        for (int i = 0; i < n - 1; i++) {
            List<String> formattedValues = controller.formatInitialValues(values, chessParams.getListType());
            System.out.println("Iteration" + (i + 1) + ": " + formattedValues);

            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (values.get(j) < values.get(minIndex)) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = values.get(minIndex);
                values.set(minIndex, values.get(i));
                values.set(i, temp);
            }

            board.updateBoard(values, chessParams, i);
            algorithmMoveController.printAndPause(chessParams.getSpeed());
        }
    }
}
