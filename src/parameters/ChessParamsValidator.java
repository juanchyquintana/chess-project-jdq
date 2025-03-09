package parameters;

import exceptions.ChessGameException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * The ChessParamsValidator class is responsible for validating chess game parameters.
 * It ensures that provided values for number of pieces, colors, types, and other settings
 * conform to predefined rules. If an invalid value is detected, an exception is thrown.
 */
public class ChessParamsValidator {
    /**
     * Validates the main chess parameters: number of pieces, color, and type.
     * @param parameters The ChessParams object containing game settings.
     * @throws ChessGameException if any parameter is invalid.
     */
    public void validateParameters(ChessParams parameters) {
        String errorMessage = validatePieceNumberColorType(parameters.getNumberOfPieces(), parameters.getColor(), parameters.getListType());

        if(errorMessage != null) {
            throw new ChessGameException(errorMessage);
        }
    }

    /**
     * Validates if the provided number of pieces, color, and type are allowed.
     * @param number The number of chess pieces.
     * @param color The color of the pieces (e.g., 'b', 'B', 'w', 'W').
     * @param types The type of list ('c', 'C', 'n', 'N').
     * @return A string with an error message if invalid, or null if valid.
     */
    private static String validatePieceNumberColorType(int number, String color, String types) {
        List<Integer> validNumbers = Arrays.asList(1, 2, 4, 6, 8, 10, 16);
        List<String> validColor = Arrays.asList("b", "B", "w", "W");
        List<String> validTypes = Arrays.asList("c", "C", "n", "N");

        if (!validTypes.contains(types)) {
            return "---> MESSAGE: Invalid List Type. Allowed values: 'c - C' or 'n - N'.";
        }

        if (!validNumbers.contains(number)) {
            return "---> MESSAGE: Invalid number of pieces. Allowed values: 1, 2, 4, 6, 8, 10, 16.";
        }

        if (!validColor.contains(color)) {
            return "---> MESSAGE: Invalid color. Allowed values: 'b - B' or 'w - W'";
        }

        return null;
    }

    /**
     * Validates that required parameters are present in the provided map.
     * @param params The map containing parameter keys and values.
     * @param keys The required parameter keys to check.
     * @throws ChessGameException if any required parameter is missing.
     */
    public void validateRequiredParams(Map<String, String> params, String... keys) {
        List<String> missingParameters = new ArrayList<>();
        String charOfKey = "";

        for (String key : keys) {
            charOfKey = key;

            if (key.equalsIgnoreCase("a")) {
                charOfKey = "Algorithm ('a')";
            } else if (key.equalsIgnoreCase("t")) {
                charOfKey = "Type ('t')";
            } else if (key.equalsIgnoreCase("c")) {
                charOfKey = "Color ('c')";
            } else if (key.equalsIgnoreCase("r")) {
                charOfKey = "Round ('r')";
            } else if (key.equalsIgnoreCase("s")) {
                charOfKey = "Speed ('s')";
            }

            if(!params.containsKey(key)) {
                missingParameters.add(charOfKey);
            }
        }

        if (!missingParameters.isEmpty()) {
            throw new ChessGameException("---> MESSAGE: Error, no parameters were provided. Your parameters empty is/are: " + String.join(", ", missingParameters));
        }
    }

    /**
     * Validates that a given value is an integer and falls within a specified range.
     * @param value The string representation of the numeric value.
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @param params The name of the parameter being validated.
     * @return The validated integer value.
     * @throws ChessGameException if the value is not numeric or out of the allowed range.
     */
    public int validateIntegerValue(String value, int min, int max, String params) {
        if (!isNumericValue(value)) {
            throw new ChessGameException("---> MESSAGE: Invalid " + params + " value. Must be a number.");
        }

        int numericValue = Integer.parseInt(value);
        if (numericValue < min || numericValue > max) {
            throw new ChessGameException("---> MESSAGE: Invalid params value. Must be between " + min + " and " + max + ". Check a " + params + " value is correct and try again.");
        }

        return numericValue;
    }

    /**
     * Checks if a given string represents a valid integer.
     * @param number The string to check.
     * @return true if the string is a valid integer, false otherwise.
     */
    private static boolean isNumericValue(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }

        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
