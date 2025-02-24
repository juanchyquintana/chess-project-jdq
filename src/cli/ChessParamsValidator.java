package cli;

import exceptions.ChessGameException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ChessParamsValidator {
    public static void validateRequiredParams(Map<String, String> params, String... keys) {
        for(String key : keys) {
            if(!params.containsKey(key)) {
                throw new ChessGameException("---> MESSAGE: Error, no parameters were provided");
            }
        }
    }

    public static boolean validatePieceNumber(int roundNumber) {
        List<Integer> validNumbers = Arrays.asList(1, 2, 4, 6, 8, 10, 16);
        return validNumbers.contains(roundNumber);
    }

    public static boolean validateCharacter(String pieceString) {
        List<String> validChars = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
        return validChars.contains(pieceString);
    }


    public static int validateParseInt(String value, String params, int min, int max) {
        if(!isNumericValue(value)) {
            throw new ChessGameException("---> MESSAGE: Invalid " + params + " value. Must be a number.");
        }

        int parsedNumber = Integer.parseInt(value);

        if(parsedNumber < min || parsedNumber > max) {
            throw new ChessGameException("---> MESSAGE: Invalid " + params + " value. Must be between " + min + " and " + max + ".");
        }

        return parsedNumber;
    }

    public static boolean isNumericValue(String text) {
        if(text == null || text.isEmpty()) {
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
