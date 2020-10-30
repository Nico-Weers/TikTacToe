package gui;

import interfaces.IRegisterGUI;
import utils.LanguageDictionary;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UsernameGUI implements IRegisterGUI {
	private JPanel rootPanel;
	private JLabel usernameOneLabel;
	private JLabel usernameTwoLabel;
	private JTextField usernameOneTextField;
	private JTextField usernameTwoTextField;
	private JButton startButton;

	@Override public void initialize(){
		usernameOneLabel.setText(LanguageDictionary.getEntry("usernameGui.content.usernameOneLabel"));
		usernameTwoLabel.setText(LanguageDictionary.getEntry("usernameGui.content.usernameTwoLabel"));
		startButton.setText(LanguageDictionary.getEntry("usernameGui.content.startButton"));
		startButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				//TODO:
			}
		});
	}

	@Override public List<String> getUsernames() {
		List<String> list = new ArrayList<>();
		list.add(usernameOneTextField.getText());
		list.add(usernameTwoTextField.getText());
		return list;
	}

	@Override public JPanel getRootPanel() {
		return rootPanel;
	}
}
