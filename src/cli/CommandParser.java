package cli;

import exceptions.ChessGameException;
import game.Game;
import utils.ChessUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Parses command-line arguments and configures a chess game accordingly.
 * Handles validation and initialization of game parameters.
 */
public class CommandParser {
    Game chess = new Game();

    /**
     * Processes input arguments and initializes a chess game with the specified parameters.
     * @param args Array of command-line arguments formatted as key-value pairs (e.g., "a=b").
     */
    public void createGameWithParams(String[] args) {
        Map<String, String> params = processParam(args);

        ChessParamsValidator.validateRequiredParams(params, "a", "t", "c", "r", "s");

        String algorithm = params.get("a").toLowerCase();
        String listType = params.get("t").toLowerCase();
        String colorType = params.get("c").toLowerCase();

        ChessParamsValidator.validateParseInt(params.get("r"), 1, 16, "Round Value ('r')");
        ChessParamsValidator.validateParseInt(params.get("s"),100, 1000, "Speed ('s')");

        int roundValue = Integer.parseInt(params.get("r"));
        int speed = Integer.parseInt(params.get("s"));

        ChessParams chessParams = new ChessParams(colorType, algorithm, listType, roundValue, speed);
        printGameArgs(params, chessParams);

        if(!ChessParamsValidator.validateType(listType)) {
            throw new ChessGameException("---> MESSAGE: Invalid List Type. Allowed values: 'c - C' or 'n - N'.");
        }

        if (!ChessParamsValidator.validatePieceNumber(roundValue)) {
            throw new ChessGameException("---> MESSAGE: Invalid number of pieces. Allowed values: 1, 2, 4, 6, 8, 10, 16.");
        }

        if (!ChessParamsValidator.validateCharacterOfColor(colorType)) {
            throw new ChessGameException("---> MESSAGE: Invalid color. Allowed values: 'b - B' or 'w - W'");
        }

        chess.startGame(params, chessParams);
    }

    /**
     * Converts an array of argument strings into a key-value map.
     * @param args Array of strings in "key=value" format.
     * @return A map containing parsed key-value pairs.
     */
    private static Map<String, String> processParam(String[] args) {
        Map<String, String> params = new HashMap<>();
        for (String arg : args) {
            String[] splitArg = arg.split("=");
            if (splitArg.length == 2) {
                params.put(splitArg[0], splitArg[1]);
            }
        }
        return params;
    }

    /**
     * Applies the selected sorting algorithm to a list of chess pieces.
     * @param algorithm The sorting algorithm identifier (e.g., "b" for Bubble Sort).
     * @param values The list of chess pieces to be sorted.
     * @param speed The delay in milliseconds between sorting steps.
     */
    private static void applySorting(String algorithm, List<String> values, int speed) {
        switch (algorithm) {
            case "b", "s", "i", "m", "q", "h", "c", "r":
                ChessUtils.executeSorting(algorithm, values, speed);
                break;
            default:
                throw new ChessGameException("---> MESSAGE: Invalid algorithm option.");
        }
        System.out.println("\nOrdenamiento: " + values + "\n");
    }

    /**
     * Prints the parsed game parameters to the console.
     * @param params A map of key-value parameter pairs.
     * @param chessParams An instance of ChessParams containing parsed values.
     */
    private void printGameArgs(Map<String, String> params, ChessParams chessParams) {
        System.out.println("*** These are your parsed parameters for the Chess Game ***");
        params.forEach((key, value) -> System.out.println("\t" + key + "=" + value));

        System.out.println(chessParams.toString());
        System.out.println("Valores: ");

        List<String> values = ChessUtils.getPiecesList(chessParams.getType(), chessParams.getRoundValue());
        applySorting(chessParams.getAlgorithm(), values, chessParams.getSpeed());

        System.out.println("*** Enjoy the Game ***");
    }
}
