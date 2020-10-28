package model;

public enum Symbol {
    CROSS(1), CIRCLE(4);

    private final int value;

    Symbol(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
