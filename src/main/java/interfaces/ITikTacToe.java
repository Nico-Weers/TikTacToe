package interfaces;

import model.GameField;
import model.Player;

public interface ITikTacToe {
    public void resetGame();
    public void startGame();
    public void setUpPlayer();
    public GameField getGameField();
    public boolean setPlayerName(int index, String username);
    public void setSymbolOnGameField(int x, int y);

    boolean playerWon();

    public Player getCurrentPlayer();
}
