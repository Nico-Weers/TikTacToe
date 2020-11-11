package model;

public class GameField {
    private static final int GAME_FIELD_HEIGHT_LENGTH = 3;
    private Symbol[][] symbols = new Symbol[GAME_FIELD_HEIGHT_LENGTH][GAME_FIELD_HEIGHT_LENGTH];

    public void setSymbol(int xCoordinate, int yCoordinate, Symbol symbol){
        if(symbols[xCoordinate][yCoordinate] != null){
            return;
        }
        symbols[xCoordinate][yCoordinate] = symbol;
    }

    public void clearGameField(){
        symbols = new Symbol[GAME_FIELD_HEIGHT_LENGTH][GAME_FIELD_HEIGHT_LENGTH];
    }

    public boolean checkWon(Player player) {
        int sumToWin = player.getSymbol().getValue() * 3;
        for (int i = 0; i < symbols.length; i++) {
            if (getHorizontalValueSum(i) == sumToWin || getVerticalValueSum(i) == sumToWin)
                return true;
        }
        if(checkDiagonalYDecrease() == sumToWin || checkDiagonalYIncrease() == sumToWin){
            return true;
        }
        return false;
    }

    private int getVerticalValueSum(int index){
        int sum = 0;
        for(Symbol symbol: symbols[index]){
            if(symbol == null){
                continue;
            }
            sum += symbol.getValue();
        }
        return sum;
    }

    private int getHorizontalValueSum(int index){
        int sum = 0;
        for (Symbol[] columns : symbols){
            if(columns[index] == null){
                continue;
            }
            sum += columns[index].getValue();
        }
        return sum;
    }

    private int checkDiagonalYDecrease(){
        int yCoordinate = 0, sum = 0;
        for (int xCoordinate = 0; xCoordinate < symbols.length ; xCoordinate++){
            if(symbols[xCoordinate][yCoordinate + xCoordinate] == null) continue;
            sum += symbols[xCoordinate][yCoordinate + xCoordinate].getValue();
        }
        return sum;
    }
    private int checkDiagonalYIncrease(){
        int yCoordinate = 2, sum = 0;
        for (int xCoordinate = 0; xCoordinate < symbols.length ; xCoordinate++){
            if(symbols[xCoordinate][yCoordinate - xCoordinate] == null) continue;
            sum += symbols[xCoordinate][yCoordinate - xCoordinate].getValue();
        }
        return sum;
    }

    public Symbol[][] getGameFieldAsSymbols(){
        return symbols;
    }
}
