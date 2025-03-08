package game;

import board.Board;
import exceptions.ChessGameException;
import moveSorting.AlgorithmMoveController;
import parameters.ChessParams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The ChessGameController class is responsible for managing and generating
 * values related to the pieces used in the chess game.
 */
public class ChessGameController {
    /**
     * Initializes and creates a new chessboard.
     * @return A fully initialized Board instance.
     */
    public Board initializeBoard() {
        Board board = new Board();
        board.createBoard();

        return board;
    }

    /**
     * Generates a list of numeric values representing chess pieces based on the number of pieces specified.
     * The list is then shuffled to randomize the values.
     * @param numberOfPiece The number of pieces to generate values for.
     * @return A shuffled list of integers representing the chess pieces.
     * @throws ChessGameException if the given number of pieces is invalid.
     */
    private List<Integer> generateValuesList(int numberOfPiece) {
        List<Integer> valueList = new ArrayList<>();

        try {
            switch (numberOfPiece) {
                case 1 -> valueList.add(1);  // King
                case 2 -> valueList.addAll(List.of(1, 2));  // King and Queen
                case 4 -> valueList.addAll(List.of(1, 2, 3, 4));  // Bishops, King and Queen
                case 6 -> valueList.addAll(List.of(1, 2, 3, 4, 5, 6));  // Knights, Bishops, King and Queen
                case 8 -> valueList.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8));  // Rooks, Knights, Bishops, King and Queen
                case 10 -> valueList.addAll(List.of(9, 10, 11, 12, 13, 14, 15, 16));  // Pawns
                case 16 -> {
                    for (int i = 1; i <= 16; i++) {
                        valueList.add(i); // Rooks, Knights, Bishops, King, Queen and Pawns
                    }
                }
                default -> throw new ChessGameException("---> MESSAGE: Invalid number of pieces");
            }
            Collections.shuffle(valueList); // Aleatory values
            return valueList;

        } catch (ChessGameException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Generates and formats the initial values for the chess pieces.
     * The values are first generated and then converted to the correct display format.
     * @param chessParams Configuration parameters for the game.
     * @return A list of integers representing formatted chess piece values.
     */
    public List<Integer> generateAndFormatValues(ChessParams chessParams) {
        List<Integer> values = generateValuesList(chessParams.getNumberOfPieces());
        List<String> formattedValues = formatInitialValues(values, chessParams.getListType());
        System.out.println("Initial Order Values: " + formattedValues);

        return values;
    }

    /**
     * Executes the sorting algorithm for the given list of chess piece values.
     * This method delegates sorting to the `AlgorithmMoveController`.
     * @param chessParams Configuration parameters for the sorting process.
     * @param board The chessboard where the sorting will be visualized.
     * @param values The list of values representing chess pieces.
     */
    public void executeSorting(ChessParams chessParams, Board board, List<Integer> values) {
        new AlgorithmMoveController().executeSorting(chessParams, board, values);
    }

    /**
     * Updates the board with the sorted chess piece values and displays the final formatted result.
     * @param board The chessboard to update.
     * @param values The list of sorted chess piece values.
     * @param chessParams Configuration parameters for the game.
     */
    public void updateBoardAndDisplayFormatedResults(Board board, List<Integer> values, ChessParams chessParams) {
        board.updateBoard(values, chessParams, chessParams.getNumberOfPieces());

        List<String> valuesSortedFormatted = formatInitialValues(values, chessParams.getListType());
        System.out.println("Final Order Values: " + valuesSortedFormatted);
    }

    /**
     * Formats a list of numerical values into a string list based on the specified list type.
     * - If typeList is "n", the values are returned as numeric strings.
     * - If typeList is "c", the values are converted to corresponding lowercase letters (e.g., 1 → 'a').
     * @param values The list of integers representing chess piece values.
     * @param typeList The type of formatting: "n" for numeric, "c" for character-based.
     * @return A formatted list of string representations of the values.
     */
    public List<String> formatInitialValues(List<Integer> values, String typeList) {
        List<String> valuesFormatted = new ArrayList<>();

        if (typeList.equalsIgnoreCase("n")) {
            for (int value : values) {
                valuesFormatted.add(String.valueOf(value));
            }
        } else if (typeList.equalsIgnoreCase("c")) {
            for (int value : values) {
                valuesFormatted.add(String.valueOf((char) ('a' + value - 1))); // Convierte a carácter
            }
        }

        return valuesFormatted;
    }
}
