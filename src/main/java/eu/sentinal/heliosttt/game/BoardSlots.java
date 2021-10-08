package eu.sentinal.heliosttt.game;

public enum BoardSlots {

    A(1, 1, 12),
    B(1, 2, 13),
    C(1, 3, 14),
    D(2, 1, 21),
    E(2, 2, 22),
    F(2, 3, 23),
    G(3, 1, 30),
    H(3, 2, 31),
    I(3, 3, 32),
    ;
    private final int row;
    private final int column;
    private final int slot;


    BoardSlots(int row, int column, int slot) {
        this.row = row;
        this.column = column;
        this.slot = slot;
    }

    public static BoardSlots getBySlot(int slot){
        for (BoardSlots value : values()) {
            if(value.slot == slot) return value;
        }
        return null;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getSlot() {
        return slot;
    }
}
