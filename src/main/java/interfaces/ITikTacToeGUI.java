package interfaces;

import javax.swing.JButton;

public interface ITikTacToeGUI extends ISwingGUI {
    public void initialize();

    void openWinDialog();

    public JButton getButton(int x, int y);
    public void resetField();
}
