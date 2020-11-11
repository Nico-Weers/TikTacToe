package gui;

import interfaces.ITikTacToe;
import interfaces.ITikTacToeGUI;
import model.GameField;
import model.Symbol;
import utils.LanguageDictionary;

import javax.swing.*;
import java.awt.*;
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
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backend.resetGame(GameGUI.this);
			}
		});
		x0y2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked(0, 2);
			}
		});
		x1y2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked(1, 2);
			}
		});
		x2y2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked(2, 2);
			}
		});
		x1y1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked(1, 1);
			}
		});
		x0y1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked(0, 1);
			}
		});
		x1y1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked(1, 1);
			}
		});
		x2y1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked(2, 1);
			}
		});
		x0y0Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked(0, 0);
			}
		});
		x1y0Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked(1, 0);
			}
		});
		x2y0Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked(2, 0);
			}
		});
	}

	private void buttonClicked(int x, int y){
		backend.setSymbolOnGameField(this, x, y);
	}

	@Override
	public void openWinDialog(String winnerName) {
		Dialog winDialog = new JDialog();
		winDialog.setTitle("Gewonnen!");
		winDialog.add(new Label("Spieler " + winnerName + " hat gewonnen!"));
		winDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		winDialog.pack();
		winDialog.setVisible(true);
	}


	@Override public JButton getButton(int x, int y) {
		return buttonTable[x][y];
	}

	@Override public JPanel getRootPanel() {
		return rootPanel;
	}
}
