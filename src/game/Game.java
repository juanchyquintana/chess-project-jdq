package game;

import board.Board;
import cli.ChessParams;
import pieces.PieceController;
import utils.ChessUtils;

import java.util.List;
import java.util.Map;

/**
 * Representa una partida de ajedrez, gestionando el tablero y el flujo de la partida.
 * Represents a chess game, managing the board and game flow.
 */
public class Game {
    private final Board board;

    /**
     * Constructor que inicializa el tablero de ajedrez.
     * Constructor that initializes the chess board.
     */
    public Game() {
        this.board = new Board();
    }

    /**
     * Inicia la partida de ajedrez con los parámetros especificados.
     * @param params Un mapa que contiene los parámetros del juego.
     * @param chessParams El objeto que contiene los parámetros de ajedrez analizados.
     * Starts the chess game with the specified parameters.
     *      * @param params A map containing the game parameters.
     *      * @param chessParams The object holding parsed chess
     */
    public void startGame(Map<String, String> params, ChessParams chessParams) {
        PieceController pieceController = new PieceController(board);

        System.out.println("---> Chess Game Started with parameters: " + params.toString() + "\n".toUpperCase());

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
                System.out.println("---> MESSAGE: Error to Start the Game. " + e.getMessage());
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
