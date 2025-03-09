package parameters;

import pieces.enums.Color;

import java.util.Map;
import java.util.Objects;

/**
 * The ChessParams class represents the parameters required to configure a chess game.
 * It includes attributes such as algorithm type, list type, piece color, number of pieces, and speed.
 */
public class ChessParams {
    private String algorithm;
    private String listType;
    private String color;
    private int numberOfPieces;
    private int speed;

    /**
     * Constructs a new ChessParams object with the specified parameters.
     * @param algorithm The sorting algorithm to be used.
     * @param listType The type of list representation ("n" for numeric, "c" for character).
     * @param color The color of the pieces ("w" for white, "b" for black).
     * @param numberOfPieces The number of pieces in the game.
     * @param speed The speed setting (in milliseconds).
     */
    public ChessParams(String algorithm, String listType, String color, int numberOfPieces, int speed) {
        this.algorithm = algorithm;
        this.listType = listType;
        this.color = color;
        this.numberOfPieces = numberOfPieces;
        this.speed = speed;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getListType() {
        return listType;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public int getSpeed() {
        return speed;
    }

    /**
     * Converts a color code ("B" for Black, "W" for White) into a readable color name.
     * @param color The color code as a string.
     * @return The uppercase name of the corresponding color.
     */
    private static String printColor(String color) {
        String isBlack = Color.BLACK.getColorName().toUpperCase();
        String isWhite = Color.WHITE.getColorName().toUpperCase();

        return color.equalsIgnoreCase("B") ? isBlack : isWhite;
    }

    /**
     * Converts a type code ("N" for Numeric, "C" for Character) into a readable format.
     * @param type The type code as a string.
     * @return The corresponding type name in uppercase. If the type is invalid, returns "TYPE NOT VALID".
     */
    private static String printType(String type) {
        if(type.equalsIgnoreCase("N")) {
            return "Numeric".toUpperCase();
        } else if (type.equalsIgnoreCase("C")) {
            return "Character".toUpperCase();
        } else {
            return "Type not valid";
        }
    }

    /**
     * Converts an algorithm code ("i" for Insertion Sort, "b" for Bubble Sort, "s" for Selection Sort)
     * into its full algorithm name.
     * @param algorithm The algorithm code as a string.
     * @return The corresponding algorithm name, or "ALGORITHM NOT VALID" if the code is unrecognized.
     */
    private static String printAlgorithm(String algorithm) {
        Map<String, String> algorithms = Map.of(
                "i", "Insertion Sort",
                "b", "Bubble Sort",
                "s", "Selection Sort"
        );
        return algorithms.getOrDefault(algorithm, "Algorithm not valid");
    }

    /**
     * Returns a formatted string representation of the game parameters.
     * @return A string containing all the chess game parameters.
     */
    @Override
    public String toString() {
        return  "\nColor: [" + printColor(color) + "]\n" +
                "Type: [" + printType(listType) + "]\n" +
                "Algorithm: [" + printAlgorithm(algorithm) + "]\n" +
                "Speed: " + speed + "ms\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessParams that = (ChessParams) o;
        return numberOfPieces == that.numberOfPieces && speed == that.speed && Objects.equals(algorithm, that.algorithm) && Objects.equals(listType, that.listType) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(algorithm, listType, color, numberOfPieces, speed);
    }
}
