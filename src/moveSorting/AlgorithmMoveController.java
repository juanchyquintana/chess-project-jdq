package moveSorting;

import board.Board;
import exceptions.ChessGameException;
import parameters.ChessParams;

import java.util.List;
import java.util.Map;

public class AlgorithmMoveController {
    public void executeSorting(ChessParams chessParams, Board board, List<Integer> values) {
        Map<String, IAlgorithmMove> algorithmMoveMap = Map.of(
                "i", new InsertionSort(),
                "b", new BubbleSort(),
                "s", new SelectionSort()
        );

        IAlgorithmMove algorithmMove = algorithmMoveMap.get(chessParams.getAlgorithm());
        if(algorithmMove == null) {
            throw new ChessGameException("---> MESSAGE: Algorithm not valid.");
        }

        algorithmMove.sort(values, board, chessParams, this);
    }

    public void printAndPause(int speed) {
        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ChessGameException("---> MESSAGE: Error printing and running algorithm", e);
        }
    }

}
