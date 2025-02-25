package pieces;

import exceptions.ChessGameException;
import pieces.enums.Color;

public abstract class Piece implements Comparable<Piece>{
    protected Color color;
    protected Object value;

    public Piece(Color color) {
        this.color = color;
    }

    public abstract boolean isValidMove(int startRow, int startColumn, int endRow, int endColumn);

    public abstract String getSymbol();

    public Color getColor(String color) {
        return color.equalsIgnoreCase("W") ? Color.WHITE : Color.BLACK;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo (Piece other) {
        if (this.value instanceof Integer && other.value instanceof Integer) {
            return ((Integer) this.value).compareTo((Integer) other.value);
        } else if (this.value instanceof String && other.value instanceof String) {
            return ((String) this.value).compareTo((String) other.value);
        } else {
            throw new ChessGameException("Cannot compare different types of values");
        }
    }
}
