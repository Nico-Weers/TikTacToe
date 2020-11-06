package gui;

import interfaces.ITikTacToe;
import interfaces.ITikTacToeGUI;
import model.GameField;
import model.Symbol;
import utils.LanguageDictionary;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI implements ITikTacToeGUI {
	private ITikTacToe backend;
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

	public GameGUI(ITikTacToe backend) {
		this.backend = backend;
		rerender();
	}

	public void rerender(){
		GameField curGameField = backend.getGameField();
		Symbol[][] symbols = curGameField.getGameField();

		for (int row = 0; row < symbols.length; row++) {
			for (int column = 0; column < symbols[row].length; column++) {
				Symbol currentSymbol = symbols[row][column];
				buttonTable[row][column].setText(Character.toString(currentSymbol.getCharacter()));
			}
		}
	}

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
		x0y2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		x1y2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		x2y2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		x1y1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		x0y1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		x1y1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		x2y1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		x0y0Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		x1y0Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		x2y0Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
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
