package model;

public class GameField {
    private static final int GAME_FIELD_HEIGHT_LENGTH = 3;
    private Symbol[][] gameField = new Symbol[GAME_FIELD_HEIGHT_LENGTH][GAME_FIELD_HEIGHT_LENGTH];

    public void setSymbol(int xCoordinate, int yCoordinate, Symbol symbol){
        if(gameField[xCoordinate][yCoordinate] != null){
            return;
        }
        gameField[xCoordinate][yCoordinate] = symbol;
    }

    public Symbol[][] getGameFieldAsSymbols(){
        return gameField;
    }

    public void clearGameField(){
        gameField = new Symbol[GAME_FIELD_HEIGHT_LENGTH][GAME_FIELD_HEIGHT_LENGTH];
    }

    public boolean checkWon(Player player) {
        int sumToWin = player.getSymbol().getValue() * 3;
        for (int i = 0; i < gameField.length; i++) {
            if (checkHorizontal(i) == sumToWin || checkVertical(i) == sumToWin) {
                return true;
            }
        }
        if(checkDiagonalyDecrease() == sumToWin){
            return true;
        }
        if(checkDiagonalyIncrease() == sumToWin){
            return true;
        }
        return false;
    }

    private int checkVertical(int index){
        int sum = 0;
        for(Symbol symbol: gameField[index]){
            if(symbol == null){
                continue;
            }
            sum += symbol.getValue();
        }
        return sum;
    }

    private int checkHorizontal(int index){
        int sum = 0;
        for (Symbol[] columns : gameField){
            if(columns[index] == null){
                continue;
            }
            sum += columns[index].getValue();
        }
        return sum;
    }

    //wenn yDecrease == true, summiert die Funktion die Werte der Symbole con links-oben nach rechts unten
    //ansonsten werden die Werte der Symbole von links-unten nach rechts-oben summiert
    private int checkDiagonalyDecrease(){
        int yCoordinate = 0, sum = 0;
        for (int xCoordinate = 0; xCoordinate < gameField.length ; xCoordinate++){
            if(gameField[xCoordinate][yCoordinate + xCoordinate] == null) continue;
            sum += gameField[xCoordinate][yCoordinate + xCoordinate].getValue();
        }
        return sum;
    }

    private int checkDiagonalyIncrease(){
        int yCoordinate = 2, sum = 0;
        for (int xCoordinate = 0; xCoordinate < gameField.length ; xCoordinate++){
            if(gameField[xCoordinate][yCoordinate - xCoordinate] == null) continue;
            sum += gameField[xCoordinate][yCoordinate - xCoordinate].getValue();
        }
        return sum;
    }
}
