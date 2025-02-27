package cli;

import exceptions.ChessGameException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ChessParamsValidator {
    public static void validateRequiredParams(Map<String, String> params, String... keys) {
        List<String> missingParameters = new ArrayList<>();

        for (String key : keys) {
            String nameOfKey = key;

            if (key.equalsIgnoreCase("a")) {
                nameOfKey = "Algorithm ('a')";
            } else if (key.equalsIgnoreCase("t")) {
                nameOfKey = "Type ('t')";
            } else if (key.equalsIgnoreCase("c")) {
                nameOfKey = "Color ('c')";
            } else if (key.equalsIgnoreCase("r")) {
                nameOfKey = "Round ('r')";
            } else if (key.equalsIgnoreCase("s")) {
                nameOfKey = "Speed ('s')";
            }

            if (!params.containsKey(key)) {
                missingParameters.add(nameOfKey);
            }
        }

        if (!missingParameters.isEmpty()) {
            throw new ChessGameException("---> MESSAGE: Error, no parameters were provided. Your parameters empty is/are: " + String.join(", ", missingParameters));
        }
    }

    public static boolean validatePieceNumber(int roundNumber) {
        List<Integer> validNumbers = Arrays.asList(1, 2, 4, 6, 8, 10, 16);
        return validNumbers.contains(roundNumber);
    }

    public static boolean validateCharacterOfColor(String pieceString) {
        List<String> validChars = Arrays.asList("b", "B", "w", "W");
        return validChars.contains(pieceString);
    }

    public static boolean validateType(String listType) {
        List<String> validCharsOfType = Arrays.asList("c", "n", "C", "N");
        return validCharsOfType.contains(listType);
    }

    public static void validateParseInt(String value, int min, int max, String params) {
        if (!isNumericValue(value)) {
            throw new ChessGameException("---> MESSAGE: Invalid " + params + " value. Must be a number.");
        }

        int numericValue = Integer.parseInt(value);

        if (numericValue < min || numericValue > max) {
            throw new ChessGameException("---> MESSAGE: Invalid params value. Must be between " + min + " and " + max + ".");
        }
    }

    public static boolean isNumericValue(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }

        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
