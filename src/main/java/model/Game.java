package model;

import interfaces.ITikTacToeGUI;
import interfaces.ITikTacToe;

public class Game implements ITikTacToe {
    private final Player[] players = {new Player(Symbol.CROSS), new Player(Symbol.CIRCLE)};

    private Player currentPlayer;

    private final GameField gameField = new GameField();

    @Override
    public void resetGame(ITikTacToeGUI gui) {
        currentPlayer = null;
        gameField.clearGameField();
        startGame();
    }

    @Override
    public void startGame() {
        switchPlayer();
    }

    @Override
    public void setSymbolOnGameField(ITikTacToeGUI gui, int x, int y){
        if(gameField.getGameFieldAsSymbols()[x][y] != null){
            return;
        }
        gameField.setSymbol(x, y, currentPlayer.getSymbol());
        rerender(gui);
        if(playerWon()){
            gui.openWinDialog(currentPlayer.getUsername());
            return;
        }
        switchPlayer();
    }

    private void rerender(ITikTacToeGUI gui) {
        Symbol[][] symbols = gameField.getGameFieldAsSymbols();
        for (int row = 0; row < symbols.length; row++) {
            for (int column = 0; column < symbols[row].length; column++) {
                Symbol currentSymbol = symbols[row][column];
                if(currentSymbol != null) {
                    gui.getButton(row, column).setText(Character.toString(currentSymbol.getCharacter()));
                    gui.getButton(row, column).setEnabled(false);
                }
                else{
                    gui.getButton(row, column).setText("");
                    gui.getButton(row, column).setEnabled(true);
                }
            }
        }
    }

    private boolean playerWon() {
        return gameField.checkWon(currentPlayer);
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

    @Override
    public boolean setPlayerName(int index, String username) {
        if(index >= players.length || index < 0){
            return false;
        }
        players[index].setUsername(username);
        return true;
    }
}
