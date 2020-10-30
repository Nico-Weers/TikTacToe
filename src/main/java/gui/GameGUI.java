package gui;

import interfaces.ITikTacToeGUI;
import utils.LanguageDictionary;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameGUI implements ITikTacToeGUI {
	private JPanel rootPanel;
	private JButton x0y2Button;
	private JButton x1y2Button;
	private JButton x2y2Button;
	private JButton x2y1Button;
	private JButton x1y1Button;
	private JButton x0y1Button;
	private JButton x2y0Button;
	private JButton x1y0Button;
	private JButton x0y0Button;
	private JButton resetButton;
	private JButton[][] buttonTable = new JButton[][]{
			{ x0y0Button, x0y1Button, x0y2Button },
			{ x1y0Button, x1y1Button, x1y2Button },
			{ x2y0Button, x2y1Button, x2y2Button }
	};

	@Override public void initialize() {
		x0y2Button.setText("");
		x1y2Button.setText("");
		x2y2Button.setText("");
		x2y1Button.setText("");
		x1y1Button.setText("");
		x0y1Button.setText("");
		x2y0Button.setText("");
		x1y0Button.setText("");
		x0y0Button.setText("");
		resetButton.setText(LanguageDictionary.getEntry("gameGui.content.resetButton"));
	}

	@Override public JButton getButton(int x, int y) {
		return buttonTable[x][y];
	}

	@Override public void resetField() {

	}

	@Override public JPanel getRootPanel() {
		return rootPanel;
	}
}
