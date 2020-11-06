package model;

public enum Symbol {
    CROSS(1, 'X'), CIRCLE(4, 'O');

    private final int value;
    private final char character;

    Symbol(int value, char character){
        this.value = value;
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public int getValue() {
        return value;
    }
}
