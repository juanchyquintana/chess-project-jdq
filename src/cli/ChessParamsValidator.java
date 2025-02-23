package cli;

import java.util.Arrays;
import java.util.List;

public class ChessParamsValidator {
    public static boolean validatePieceNumber(int roundNumber) {
        return roundNumber >= 1 && roundNumber <= 16;
    }

    public static boolean validateCharacter(String pieceString) {
        List<String> validChars = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
        return validChars.contains(pieceString);
    }
}
