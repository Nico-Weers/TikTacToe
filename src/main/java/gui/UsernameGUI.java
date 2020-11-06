package gui;

import interfaces.IRegisterGUI;

import utils.LanguageDictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class UsernameGUI extends JDialog implements IRegisterGUI {
	private static final int DIALOG_HEIGTH = 200;
	private static final int DIALOG_WIDTH = 400;

	private JPanel rootPanel;
	private JLabel usernameOneLabel;
	private JLabel usernameTwoLabel;
	private JTextField usernameOneTextField;
	private JTextField usernameTwoTextField;
	private JButton startButton;

	private boolean canStart = false;

	public UsernameGUI(Frame frame){
		super(frame);
	}

	@Override public void initialize(){
		usernameOneLabel.setText(LanguageDictionary.getEntry("usernameGui.content.usernameOneLabel"));
		usernameTwoLabel.setText(LanguageDictionary.getEntry("usernameGui.content.usernameTwoLabel"));
		startButton.setText(LanguageDictionary.getEntry("usernameGui.content.startButton"));
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		startButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		rootPanel.addKeyListener(new KeyListener() {
			 @Override
			 public void keyTyped(KeyEvent e) {

			 }

			 @Override
			 public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					start();
				}
			 }

			 @Override
			 public void keyReleased(KeyEvent e) {

			 }
		 }
		);
		this.add(rootPanel);
	}

	private void start() {
		if(!this.usernameOneTextField.getText().equals("") && !this.usernameTwoTextField.getText().equals("")){
			canStart = true;
			this.dispose();
		}
	}

	@Override public List<String> getUsernames() {
		List<String> list = new ArrayList<>();
		list.add(usernameOneTextField.getText());
		list.add(usernameTwoTextField.getText());
		return list;
	}

	@Override
	public List<String> showAndWait() {
		this.setSize(DIALOG_WIDTH, DIALOG_HEIGTH);
		this.setVisible(true);
		while(!canStart){
		}
		return getUsernames();
	}

	@Override public JPanel getRootPanel() {
		return rootPanel;
	}
}
