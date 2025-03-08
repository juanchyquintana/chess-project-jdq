package moveSorting;

import board.Board;
import game.ChessGameController;
import parameters.ChessParams;

import java.util.List;

/**
 * Implements the Bubble Sort algorithm for sorting chess piece values.
 * This algorithm iterates through the list, swapping adjacent elements
 * if they are in the wrong order, ensuring the largest elements "bubble up" to the top.
 */
public class BubbleSort implements IAlgorithmMove {
    @Override
    public void sort(List<Integer> values, Board board, ChessParams chessParams, AlgorithmMoveController algorithmMoveController) {
        ChessGameController controller = new ChessGameController();

        int n = values.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            List<String> formattedValues = controller.formatInitialValues(values, chessParams.getListType());
            System.out.println("Iteration " + (i + 1) + ": " + formattedValues);

            for (int j = 0; j < n - i - 1; j++) {
                if (values.get(j) > values.get(j + 1)) {
                    // Intercambiar elementos
                    int temp = values.get(j);
                    values.set(j, values.get(j + 1));
                    values.set(j + 1, temp);
                    swapped = true;
                }
            }

            board.updateBoard(values, chessParams, i);
            algorithmMoveController.printAndPause(chessParams.getSpeed());

            if (!swapped) {
                break;
            }
        }

    }
}
