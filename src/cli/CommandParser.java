package cli;

import exceptions.ChessGameException;
import game.Game;
import utils.ChessUtils;

import java.lang.reflect.Parameter;
import java.util.*;

/**
 * Analiza los argumentos de la línea de comandos y configura un juego de ajedrez en consecuencia.
 * Maneja la validación e inicialización de los parámetros del juego.
 * Parses command-line arguments and configures a chess game accordingly.
 * Handles validation and initialization of game parameters.
 */
public class CommandParser {
    Game chess = new Game();

    /**
     * Procesa los argumentos de entrada e inicializa una partida de ajedrez con los parámetros especificados.
     * @param args Matriz de argumentos de línea de comandos formateados como pares clave-valor (por ejemplo, «a=b»).
     * Processes input arguments and initializes a chess game with the specified parameters.
     *  *@param args Array of command-line arguments formatted as key-value pairs (e.g., "a=b").
     */
    public void createGameWithParams(String[] args) {
        Map<String, String> params = processParam(args);

        try {
            if (!params.containsKey("a") || !params.containsKey("t") || !params.containsKey("c") || !params.containsKey("r") || !params.containsKey("s")) {
                throw new IllegalArgumentException("---> MESSAGE: Error, no parameters were provided");
            }

            String algorithm = params.get("a").toLowerCase();
            String listType = params.get("t").toLowerCase();
            String colorType = params.get("c").toLowerCase();
            int roundValue = Integer.parseInt(params.get("r"));
            int speed = Integer.parseInt(params.get("s"));

            if(!ChessParamsValidator.validatePieceNumber(roundValue)) {
                System.out.println("---> MESSAGE: Invalid number of pieces, must be between 1 and 16.");
                return;
            }

            if(!ChessParamsValidator.validateCharacter(colorType)) {
                System.out.println("---> MESSAGE: Invalid piece character.");
                return;
            }

            ChessParams chessParams = new ChessParams(colorType, algorithm, listType, roundValue, speed);
            printGameArgs(params, chessParams);

            // Extraemos la lógica de los algoritmos y otros parámetros.
            chess.startGame(params, chessParams); // Iniciar el juego con los parámetros procesados
        } catch (IllegalArgumentException e) {
            throw new ChessGameException("---> MESSAGE: Error parsing parameters. Check your input", e);
        }
    }

    /**
     * Convierte una matriz de cadenas de argumentos en un mapa clave-valor.
     * @param args Matriz de cadenas en formato «clave=valor».
     * @return Un mapa que contiene pares clave-valor analizados.
     *      * Converts an array of argument strings into a key-value map.
     *      * @param args Array of strings in "key=value" format.
     *      * @return A map containing parsed key-value pairs.
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
     * Aplica el algoritmo de ordenación seleccionado a una lista de piezas de ajedrez.
     * @param algorithm Identificador del algoritmo de ordenación (por ejemplo, «b» para Bubble Sort).
     * @param values La lista de piezas de ajedrez a ordenar.
     * @param speed Retraso en milisegundos entre los pasos de ordenación.
     *      * Applies the selected sorting algorithm to a list of chess pieces.
     *      * @param algorithm The sorting algorithm identifier (e.g., "b" for Bubble Sort).
     *      * @param values The list of chess pieces to be sorted.
     *      * @param speed The delay in milliseconds between sorting steps.
     */
    private static void applySorting(String algorithm, List<String> values, int speed) {
        switch (algorithm) {
            case "b":
            case "s":
            case "i":
                ChessUtils.executeSorting(algorithm, values, speed);
                break;
            default:
                System.out.println("---> MESSAGE: Invalid algorithm option.");
                break;
        }

        System.out.println("\nOrdenamiento: " + values);
    }


    /**
     * Imprime los parámetros del juego en la consola.
     * @param params Un mapa de pares de parámetros clave-valor.
     * @param chessParams Una instancia de ChessParams que contiene los valores analizados.
     *      * Prints the parsed game parameters to the console.
     *      * @param params A map of key-value parameter pairs.
     *      * @param chessParams An instance of ChessParams containing parsed values.
     */
    private void printGameArgs(Map<String, String> params, ChessParams chessParams) {
        System.out.println("*** These are your parsed parameters for the Chess Game ***");
        params.forEach((key, value) -> System.out.println("\t" + key + "=" + value));

        System.out.println("Color: [" + ChessUtils.printColor(chessParams.getColor()) + "]");
        System.out.println("Tipo: [" + ChessUtils.printTypeText(chessParams.getType()) + "]");

        System.out.println("Algoritmo: [" + ChessUtils.printTypeOfAlgorithm(chessParams.getAlgorithm()) + "]");
        System.out.println("Speed: " + chessParams.getSpeed() + "ms");

        System.out.println("Valores: ");
        List<String> values = ChessUtils.getPiecesList(chessParams.getType(), chessParams.getRoundValue());
        applySorting(chessParams.getAlgorithm(), values, chessParams.getSpeed());

        System.out.println("*** Enjoy the Game ***");
    }
}
