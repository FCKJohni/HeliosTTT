package eu.sentinal.heliosttt.game;

public enum Mark {

    CROSS('X'),
    CIRCLE('O'),
    BLANK(' ');

    private final char symbol;

    Mark(char initMark) {
        this.symbol = initMark;
    }

    public boolean isMarked() {
        return this != BLANK;
    }

    public char getMark() {
        return this.symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
