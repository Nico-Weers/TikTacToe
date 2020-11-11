package interfaces;

import model.GameField;
import model.Player;

public interface ITikTacToe {
    public void resetGame(ITikTacToeGUI gui);
    public void startGame();
    public void setUpPlayer();
    public boolean setPlayerName(int index, String username);
    public void setSymbolOnGameField(ITikTacToeGUI gui, int x, int y);
    public Player getCurrentPlayer();
}
