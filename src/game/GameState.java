package game;

/**
 * Represents the different states a chess game can have.
 */
public enum GameState {
    ONGOING("On Going"),
    CHECKMATE("Checkmate"),
    STALEMATE("Stalemate"),
    DRAW("Draw");

    private String gameStateName;

    /**
     * Constructor for the game state enum.
     * @param gameStateName The string representation of the game state.
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
