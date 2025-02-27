package utils;

import exceptions.ChessGameException;
import moves.*;
import pieces.enums.Color;

import java.util.*;

public class ChessUtils {
    public static String printColor(String color) {
        String isBlack = Color.BLACK.getColorName().toUpperCase();
        String isWhite = Color.WHITE.getColorName().toUpperCase();

        return color.equalsIgnoreCase("B") ? isBlack : isWhite;
    }

    public static String printTypeText(String type) {
        String isNumeric = "Numeric".toUpperCase();
        String isCharacter = "Character".toUpperCase();
        String invalidType = "Type not valid".toUpperCase();

        if (type.equalsIgnoreCase("N")) {
            return isNumeric;
        } else if (type.equalsIgnoreCase("C")) {
            return isCharacter;
        } else {
            return invalidType;
        }
    }

    public static String printTypeOfAlgorithm(String algorithm) {
        Map<String, String> nameOfTypeAlgorithm = Map.of(
                "s", "Selection Sort",
                "b", "Bubble Sort",
                "i", "Insertion Sort",
                "q", "Quick Sort"
        );

        // usca directamente el valor sin múltiples comparaciones.
        return nameOfTypeAlgorithm.getOrDefault(algorithm, "Algorithm not found");
    }

    public static List<String> getPiecesList(String type, int roundValue) {
        String[] pieceTypes = {"king", "queen", "rook", "rook", "bishop", "bishop", "knight", "knight",
                "pawn", "pawn", "pawn", "pawn", "pawn", "pawn", "pawn", "pawn"};
        List<String> pieces = new ArrayList<>(Arrays.asList(pieceTypes));

        if (roundValue > pieces.size()) {
            System.out.println("---> MESSAGE: roundValue exceeds available pieces. Adjusting to max size.");
            roundValue = pieces.size(); // Evita IndexOutOfBoundsException
        }

        List<String> selectedPieces = new ArrayList<>(pieces.subList(0, roundValue));
        Collections.shuffle(selectedPieces);
        return selectedPieces;
    }

    public static String convertToPieceChar(String pieceName) {
        String typePiece = pieceName.toLowerCase();

        if (typePiece.equalsIgnoreCase("pawn")) {
            return "p";
        } else if (typePiece.equalsIgnoreCase("rook")) {
            return "r";
        } else if (typePiece.equalsIgnoreCase("knight")) {
            return "h"; // Usamos "h" para caballo
        } else if (typePiece.equalsIgnoreCase("bishop")) {
            return "b";
        } else if (typePiece.equalsIgnoreCase("queen")) {
            return "q";
        } else if (typePiece.equalsIgnoreCase("king")) {
            return "k";
        } else {
            throw new ChessGameException("---> MESSAGE: Error, unknown piece type: " + pieceName);
        }
    }

    public static void executeSorting(String algorithm, List<String> values, int speed) {
        Map<String, AlgorithmMove> algorithmMoveMap = Map.of(
                "b", new BubbleSort(),
                "s", new SelectionSort(),
                "i", new InsertionSort(),
                "q", new QuickSort()
        );

        AlgorithmMove algorithmMove = algorithmMoveMap.get(algorithm);
        if (algorithmMove == null) {
            throw new ChessGameException("---> MESSAGE: Algorithm not valid.");
        }

        algorithmMove.sort(values, speed);
    }

    public static void printOrderAndPause(List<String> values, int speed) {
        System.out.println(values);
        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new ChessGameException("---> MESSAGE: Error printing and running algorithm", e);
        }
    }
}
