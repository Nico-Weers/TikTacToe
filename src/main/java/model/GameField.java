package model;

public class GameField {
    private static final int GAME_FIELD_HEIGHT_LENGTH = 3;
    private final Symbol[][] gameField = new Symbol[GAME_FIELD_HEIGHT_LENGTH][GAME_FIELD_HEIGHT_LENGTH];

    public void setSymbol(int xCoordinate, int yCoordinate, Symbol symbol){
        if(gameField[xCoordinate][yCoordinate] != null){
            return;
        }
        gameField[xCoordinate][yCoordinate] = symbol;
    }

    public void clearGameField(){
        for (Symbol[] column : gameField){
            for (Symbol cell : column){
                cell = null;
            }
        }
    }

    public boolean checkWon(Player player) {
        int sumToWin = player.getSymbol().getValue() * 3;
        for (int i = 0; i < gameField.length; i++) {
            if (checkHorizontal(i) == sumToWin || checkVertical(i) == sumToWin) {
                return true;
            }
        }
        if(checkDiagonal(true) == sumToWin){
            return true;
        }
        if(checkDiagonal(false) == sumToWin){
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
    private int checkDiagonal(boolean yDecrease){
        int yCoordinate = 0, sum = 0;
        if(yDecrease){
            yCoordinate = GAME_FIELD_HEIGHT_LENGTH;
        }
        for (int xCoordinate = 0; xCoordinate < gameField.length ; xCoordinate++){
            if(gameField[xCoordinate][yCoordinate+xCoordinate] == null) continue;
            if(yDecrease) sum += gameField[xCoordinate][yCoordinate-xCoordinate].getValue();
            if(!yDecrease) sum += gameField[xCoordinate][yCoordinate+xCoordinate].getValue();
        }
        return sum;
    }
}
