package cli;

import java.util.Objects;

/**
 * Representa los parámetros necesarios para configurar una partida de ajedrez.
 * Estos incluyen color, algoritmo de ordenación, tipo de juego, número de rondas y velocidad.
 * Represents the parameters required to configure a chess game.
 *  * These include color, sorting algorithm, game type, number of rounds, and speed.
 */
public class ChessParams {
    private String color;
    private String algorithm;
    private String type;
    private int roundValue;
    private int speed;

    /**
     * Constructor para inicializar los parámetros del juego de ajedrez.
     * @param color El color de las piezas (por ejemplo, «blanco» o «negro»).
     * @param algorithm El algoritmo de ordenación utilizado para el juego.
     * @param type El tipo de juego (por ejemplo, criterio de selección de piezas).
     * @param roundValue El número de rondas del juego.
     * @param speed La velocidad de ejecución (en milisegundos).
     *  * Constructor to initialize chess game parameters.
     *      * @param color The color of the pieces (e.g., "white" or "black").
     *      * @param algorithm The sorting algorithm used for the game.
     *      * @param type The type of the game (e.g., piece selection criteria).
     *      * @param roundValue The number of game rounds.
     *      * @param speed The speed of execution (in milliseconds).
     */
    public ChessParams(String color, String algorithm, String type, int roundValue, int speed) {
        this.color = color;
        this.algorithm = algorithm;
        this.type = type;
        this.roundValue = roundValue;
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRoundValue() {
        return roundValue;
    }

    public void setRoundValue(int roundValue) {
        this.roundValue = roundValue;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "ChessParams{" +
                "color=" + color +
                ", algorithm=" + algorithm +
                ", type=" + type +
                ", roundValue=" + roundValue +
                ", speed=" + speed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessParams that = (ChessParams) o;
        return color == that.color && algorithm == that.algorithm && type == that.type && roundValue == that.roundValue && speed == that.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, algorithm, type, roundValue, speed);
    }
}
