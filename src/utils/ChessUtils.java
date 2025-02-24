package utils;

import exceptions.ChessGameException;
import moves.*;
import pieces.enums.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChessUtils {
    public static String printColor(String color) {
        String isBlack = Color.BLACK.getColorName().toUpperCase();
        String isWhite = Color.WHITE.getColorName().toUpperCase();

        return color.equalsIgnoreCase("B") ? isBlack : isWhite;
    }

    public static String printTypeText(String type) {
        String isNumeric = "Numeric".toUpperCase();
        String isCharacter = "Character".toUpperCase();

        return type.equalsIgnoreCase("N") ? isNumeric : isCharacter;
    }

    public static String printTypeOfAlgorithm(String algorithm) {
        switch (algorithm) {
            case "s":
                return "Selection Sort";
            case "b":
                return "Bubble Sort";
            case "i":
                return "Insertion Sort";
            case "m":
                return "Merge Sort";
            case "q":
                return "Quick Sort";
            case "h":
                return "Heap Sort";
            case "c":
                return "Counting Sort";
            case "r":
                return "Radix Sort";
            default:
                return "Algorithm not found";
        }
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
        switch (pieceName.toLowerCase()) {
            case "pawn":
                return "p";
            case "rook":
                return "r";
            case "knight":
                return "h";  // Usamos "h" para caballo
            case "bishop":
                return "b";
            case "queen":
                return "q";
            case "king":
                return "k";
            default:
                throw new IllegalArgumentException("Unknown piece type: " + pieceName);
        }
    }

    public static void executeSorting(String algorithm, List<String> values, int speed) {
        AlgorithmMove algorithmMove;
        switch (algorithm) {
            case "b":
                algorithmMove = new BubbleSort();
                break;
            case "s":
                algorithmMove = new SelectionSort();
                break;
            case "i":
                algorithmMove = new InsertionSort();
                break;
            case "m":
                algorithmMove = new MergeSort();
                break;
            case "q":
                algorithmMove = new QuickSort();
                break;
            case "h":
                algorithmMove = new HeapSort();
                break;
            case "c":
                algorithmMove = new CountingSort();
                break;
            case "r":
                algorithmMove = new RadixSort();
                break;
            default:
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
