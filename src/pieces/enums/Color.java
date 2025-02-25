package pieces.enums;

/**
 * Represents the possible colors of chess pieces.
 */
public enum Color {
    WHITE("White"), BLACK("Black");

    private final String colorName;

    /**
     * Constructor to initialize the color.
     * @param colorName The name of the color.
     */
    Color(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }

    public String toString() {
        return colorName;
    }
}
