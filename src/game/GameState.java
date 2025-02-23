package game;

/**
 * Representa los diferentes estados que puede tener una partida de ajedrez.
 * Represents the different states a chess game can have.
 */
public enum GameState {
    ONGOING("On Going"),
    CHECKMATE("Checkmate"),
    STALEMATE("Stalemate"),
    DRAW("Draw");

    private String gameStateName;

    /**
     * Constructor para el enum del estado del juego.
     * @param gameStateName La representación en cadena del estado del juego.
     * Constructor for the game state enum.
     *      * @param gameStateName The string representation of the game state.
     */
    GameState(String gameStateName) {
        this.gameStateName = gameStateName;
    }

    public String getGameStateName() {
        return gameStateName;
    }

    public void setGameStateName(String gameStateName) {
        this.gameStateName = gameStateName;
    }

    public String toString() {
        return gameStateName;
    }
}
