package model;

import interfaces.ITikTacToeGUI;
import interfaces.ITikTacToe;

public class Game implements ITikTacToe {
    Player[] players = {new Player(Symbol.CROSS), new Player(Symbol.CIRCLE)};

    Player currentPlayer;

    GameField gameField = new GameField();

    public void resetGame(ITikTacToeGUI gui) {
        gameField.clearGameField();
        gui.resetField();
    }

    public void resetGame() {
        gameField.clearGameField();
    }

    public void startGame() {
        setUpPlayer();
    }

    public void setUpPlayer() {
        switchPlayer();
    }

    private void switchPlayer() {
        if(currentPlayer == null){
            currentPlayer = players[0];
            return;
        }
        if(currentPlayer.equals(players[0])) {
            currentPlayer = players[1];
        } else {
            currentPlayer = players[0];
        }
    }

    public boolean setPlayerName(int index, String username) {
        if(index >= players.length || index < 0){
            return false;
        }
        players[index].setUsername(username);
        return true;
    }
}
