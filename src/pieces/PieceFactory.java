package pieces;

import exceptions.ChessGameException;
import pieces.enums.Color;
import pieces.types.*;


public class PieceFactory {
    public static Piece createPiece(String pieceType, Color color) {
        switch (pieceType.toLowerCase()) {
            case "pawn":
                return new Pawn(color);
            case "rook":
                return new Rook(color);
            case "knight":
                return new Knight(color);
            case "bishop":
                return new Bishop(color);
            case "queen":
                return new Queen(color);
            case "king":
                return new King(color);
            default:
                throw new ChessGameException("---> Piece not recognized");
        }
    }
}
