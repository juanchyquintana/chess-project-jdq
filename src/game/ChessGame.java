package game;

import board.Board;
import exceptions.ChessGameException;
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
        Board board = chessGameController.initializeBoard();

        List<Integer> values = chessGameController.generateAndFormatValues(chessParams); // Generate and format the initial values
        chessGameController.executeSorting(chessParams, board, values); // Execute sorting based on parameters

        chessGameController.updateBoardAndDisplayFormatedResults(board, values, chessParams); // Format and display the final sorted values
    }
}
