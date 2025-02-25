package pieces.piece;

import exceptions.ChessGameException;
import pieces.IPiece;
import pieces.enums.Color;
import pieces.types.*;


public class PieceFactory {
    public static IPiece createPiece(String pieceType, Color color) {
        return switch (pieceType.toLowerCase()) {
            case "pawn" -> new Pawn(color);
            case "rook" -> new Rook(color);
            case "knight" -> new Knight(color);
            case "bishop" -> new Bishop(color);
            case "queen" -> new Queen(color);
            case "king" -> new King(color);
            default -> throw new ChessGameException("---> Piece not recognized");
        };
    }
}
