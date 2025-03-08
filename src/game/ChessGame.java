package game;

import board.Board;
import exceptions.ChessGameException;
import moveSorting.AlgorithmMoveController;
import parameters.ChessParams;

import java.util.List;

/**
 * The ChessGame class is responsible for managing the overall chess game flow,
 * including board creation, value generation, sorting execution, and final board updates.
 */
public class ChessGame {
    /**
     * Starts the chess game by initializing the board, generating piece values, sorting them,
     * and updating the board accordingly.
     * @param chessParams The ChessParams object containing game settings.
     * @throws ChessGameException if any error occurs during the game execution.
     */
    public void startGame(ChessParams chessParams) {
        ChessGameController chessGameController = new ChessGameController();
        AlgorithmMoveController algorithmMoveController = new AlgorithmMoveController();
        Board board = new Board();

        try {
            // Create the board
            board.createBoard();

            // Generate and format the initial values
            List<Integer> values = chessGameController.generateValuesList(chessParams.getNumberOfPieces());
            List<String> formattedValues = chessGameController.formatInitialValues(values, chessParams.getListType());
            System.out.println("Initial Order Values: " + formattedValues);

            // Execute sorting based on parameters
            algorithmMoveController.executeSorting(chessParams, board, values);

            // Update the board with sorted values
            board.updateBoard(values, chessParams, chessParams.getNumberOfPieces());

            // Format and display the final sorted values
            List<String> valuesSortedFormatted = chessGameController.formatInitialValues(values, chessParams.getListType());
            System.out.println("Final Order Values: " + valuesSortedFormatted);
        } catch (Exception e) {
            throw new ChessGameException("---> MESSAGE: An unexpected error occurred during the game execution.", e);
        }
    }
}
