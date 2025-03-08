package cli;

import game.ChessGame;
import parameters.ChessParams;
import parameters.ChessParamsValidator;

import java.util.HashMap;
import java.util.Map;

/**
 * The @code ChessSystem class is responsible for managing the chess game system.
 * It follows the Singleton pattern to ensure a single instance is used throughout the application.
 */
public class ChessSystem {
    private static final ChessSystem INSTANCE = new ChessSystem();

    ChessGame chess = new ChessGame();
    ChessParamsValidator chessParamsValidator = new ChessParamsValidator();

    /**
     * Retrieves the single instance of ChessSystem.
     */
    private ChessSystem() {
    }

    // Singleton pattern for ChessSystem instance
    public static ChessSystem getInstance() {
        return INSTANCE;
    }

    /**
     * Processes input arguments and initializes a chess game with the specified parameters.
     * @param args Array of command-line arguments formatted as key-value pairs (e.g., "a=b").
     */
    public void createGameWithParams(String[] args) {
        Map<String, String> params = processParam(args);
        chessParamsValidator.validateRequiredParams(params, "a", "t", "c", "r", "s");

        String algorithm = params.get("a").toLowerCase();
        String listType = params.get("t").toLowerCase();
        String color = params.get("c").toLowerCase();
        int numberOfPieces = chessParamsValidator.validateIntegerValue(params.get("r"), 1, 16, "Round Value ('r')");
        int speed = chessParamsValidator.validateIntegerValue(params.get("s"),100, 1000, "Speed ('s')");

        ChessParams chessParams = new ChessParams(algorithm, listType, color, numberOfPieces, speed);
        chessParamsValidator.validateParameters(chessParams);

        printGameSettings(params, chessParams);
        chess.startGame(chessParams);
    }

    /**
     * Prints the parsed game parameters to the console.
     * @param params A map of key-value parameter pairs.
     * @param chessParams An instance of ChessParams containing parsed values.
     */
    private void printGameSettings(Map<String, String> params, ChessParams chessParams) {
        System.out.println("*** These are your parsed parameters for the Chess Game ***");
        params.forEach((key, value) -> System.out.print(" " + key + "=" + value));

        System.out.println("\n" + chessParams.toString());
    }

    /**
     * Converts an array of argument strings into a key-value map.
     * @param args Array of strings in "key=value" format.
     * @return A map containing parsed key-value pairs.
     */
    private Map<String, String> processParam(String[] args) {
        Map<String, String> parameters = new HashMap<>();

        for(String arg : args) {
            String[] split = arg.split("=");

            if(split.length == 2) {
                parameters.put(split[0], split[1]);
            }
        }

        return parameters;
    }
}
