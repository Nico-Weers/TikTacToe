package interfaces;

import model.GameField;

public interface ITikTacToe {
    public void resetGame();
    public void startGame();
    public void setUpPlayer();
    public GameField getGameField();
    public boolean setPlayerName(int index, String username);

}
