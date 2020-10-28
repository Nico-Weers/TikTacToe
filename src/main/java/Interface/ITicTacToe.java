package Interface;

public interface ITicTacToe {
    public void resetGame();
    public void startGame();
    public void setUpPlayer();
    public void switchPlayer();
    public boolean setPlayerName(int index, String username);

}
