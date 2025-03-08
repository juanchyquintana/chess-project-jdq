package moveSorting;

import board.Board;
import game.ChessGameController;
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

        int n = values.size();
        for (int i = 0; i < n; i++) {  // Empezamos desde la segunda pieza
            int key = values.get(i);
            int j = i - 1;

            // Mover los elementos mayores que la key hacia la derecha
            while (j >= 0 && values.get(j) > key) {
                values.set(j + 1, values.get(j));
                j--;
            }
            // Insertar la key en la posición correcta
            values.set(j + 1, key);

            List<String> formattedValues = controller.formatInitialValues(values, chessParams.getListType());
            System.out.println("Iteration " + (i + 1) + ": " + formattedValues);

            board.updateBoard(values, chessParams, i);
            algorithmMoveController.printAndPause(chessParams.getSpeed());
        }
    }
}
