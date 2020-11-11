package interfaces;

import javax.swing.JButton;

public interface ITikTacToeGUI extends ISwingGUI {
    public void initialize();
    public void openWinDialog(String winnerName);
    public JButton getButton(int x, int y);
}
