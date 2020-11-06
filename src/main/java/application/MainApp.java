package application;

import gui.GameGUI;
import gui.UsernameGUI;
import interfaces.IRegisterGUI;
import interfaces.ITikTacToeGUI;
import interfaces.ITikTacToe;
import model.Game;

import javax.swing.*;

public class MainApp {

    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_WIDTH = 400;

    private JFrame frame = new JFrame("");

    public void start(){
        IRegisterGUI registerGUI = new UsernameGUI(frame);
        registerGUI.initialize();
        registerGUI.showAndWait();
        configFrame();
        ITikTacToe backend = new Game();
        ITikTacToeGUI gameGui = new GameGUI(backend);
        gameGui.initialize();
        frame.setContentPane(gameGui.getRootPanel());
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
