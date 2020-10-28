package model;

import Interface.ITikTacToeGUI;
import Interface.ITicTacToe;

public class Game implements ITicTacToe {
    Player playerOne = new Player(Symbol.CROSS);
    Player playerTwo = new Player(Symbol.CIRCLE);
    Player currentPlayer = null;

    GameField gameField = new GameField();

    public void resetGame(ITikTacToeGUI gui) {
        gameField.clearGameField();
        gui.resetField();
    }

    public void startGame() {

    }

    public void setUpPlayer() {

    }

    public void switchPlayer() {
        if(currentPlayer==playerTwo){
            currentPlayer=playerOne;
        } else {
            currentPlayer = playerTwo;
        }
    }

    public boolean setPlayerName(int index, String username) {
        if(index == 1){
            playerOne.setUsername(username);
            return true;
        } else if(index == 2){
            playerTwo.setUsername(username);
            return true;
        }
        return false;
    }
}
