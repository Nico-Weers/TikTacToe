package interfaces;

public interface ITikTacToe {
    public void startGame();
    public void resetGame(ITikTacToeGUI gui);
    public boolean setPlayerName(int index, String username);
    public void setSymbolOnGameField(ITikTacToeGUI gui, int x, int y);
}
