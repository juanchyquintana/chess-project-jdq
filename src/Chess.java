import cli.ChessSystem;

/**
 * Entry point for the Chess game.
 * Initializes the Chess system and starts the game.
 * Command-line parameters:
 * - "a" -> Algorithm ("i" for Insertion, "b" for Bubble, "s" for Selection).
 * - "t" -> List type ("n" for Numeric, "c" for Character).
 * - "c" -> Color ("W" for White, "B" for Black).
 * - "r" -> Number of pieces.
 * - "s" -> Speed in milliseconds.
 */
public class Chess {
    /**
     * The main method that starts the chess game.
     * It creates an instance of ChessSystem and calls createGameWithParams
     * to process the command-line arguments and set up the game.
     * @param args Command-line arguments used to configure the game parameters.
     */
    public static void main(String[] args) {
        ChessSystem runGame = ChessSystem.getInstance();
        runGame.createGameWithParams(args);
    }
}
