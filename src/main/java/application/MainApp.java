package application;

import gui.GameGUI;
import gui.UsernameGUI;
import interfaces.IRegisterGUI;
import interfaces.ITikTacToeGUI;
import interfaces.ITikTacToe;
import model.Game;

import javax.swing.*;
import java.util.List;

public class MainApp {

    private static final int FRAME_HEIGHT = 500;
    private static final int FRAME_WIDTH = 400;

    private JFrame frame = new JFrame("");

    public void start(){
        IRegisterGUI registerGUI = new UsernameGUI(frame);
        registerGUI.initialize();
        List<String> usernames = registerGUI.showAndWait();
        ITikTacToe backend = new Game();
        ITikTacToeGUI gui = new GameGUI(backend);
        gui.initialize();
        configFrame();
        frame.setContentPane(gui.getRootPanel());
    }

    private void configFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public static void main(String[] ignore){
        MainApp main = new MainApp();
        main.start();
    }
}
