public enum Direction {
    LEFT('l'),

    RIGHT('r');

    private final char alternateName;

    Direction(char alternateName) {
        this.alternateName = alternateName;
    }

    public char getAlternateName() {
        return alternateName;
    }

    public static Direction fromName(char name) {
        for (Direction value : values()) {
            if (value.getAlternateName() == name) {
                return value;
            }
        }

        throw new IllegalArgumentException("Unknown name: " + name);
    }
}
