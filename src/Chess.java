import cli.ChessSystem;

/**
 * The Chess class serves as the entry point for the chess game application.
 * It initializes the game system and starts the game using command-line parameters.
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
