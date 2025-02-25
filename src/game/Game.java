package game;

import board.Board;
import cli.ChessParams;
import exceptions.ChessGameException;
import pieces.piece.PieceController;
import utils.ChessUtils;

import java.util.List;
import java.util.Map;

/**
 * Represents a chess game, managing the board and game flow.
 */
public class Game {
    private final Board board;

    /**
     * Constructor that initializes the chess board.
     */
    public Game() {
        this.board = new Board();
    }

    /**
     * Starts the chess game with the specified parameters.
     * @param params A map containing the game parameters.
     * @param chessParams The object holding parsed chess
     */
    public void startGame(Map<String, String> params, ChessParams chessParams) {
        board.createBoard();

        PieceController pieceController = new PieceController(board);

        System.out.println("\n---> Chess Game Started with parameters: " + params.toString());

        String color = chessParams.getColor();
        String type = chessParams.getType();
        int roundValue = chessParams.getRoundValue();
        int speed = chessParams.getSpeed();

        List<String> pieces = ChessUtils.getPiecesList(type, roundValue);

        int currentPieceIndex = 0;
        for (int i = 0; i < roundValue; i++) {
            System.out.println("\nGame Iteration " + (i + 1) + ":");

            if (currentPieceIndex < pieces.size()) {
                String pieceName = pieces.get(currentPieceIndex++);
                String pieceChar = ChessUtils.convertToPieceChar(pieceName);

                pieceController.insertPieces(pieceChar, color);
            }

            board.printBoard(); // Mostrar el tablero
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                throw new ChessGameException("---> MESSAGE: Error to Start the Game. " + e.getMessage());
            }
        }
    }
}
