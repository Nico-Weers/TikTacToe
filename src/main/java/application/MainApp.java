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

    private final JFrame frame = new JFrame("");

    public void start(){
        IRegisterGUI registerGUI = new UsernameGUI(frame);
        registerGUI.initialize();
        List<String> usernames = registerGUI.showAndWait();
        ITikTacToe backend = new Game();
        configBackend(backend, usernames);
        ITikTacToeGUI gui = new GameGUI(backend);
        gui.initialize();
        configFrame(gui.getRootPanel());
    }

    private void configBackend(ITikTacToe backend, List<String> usernames){
        backend.setPlayerName(0, usernames.get(0));
        backend.setPlayerName(1, usernames.get(1));
        backend.startGame();
    }

    private void configFrame(JPanel rootPanel) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setContentPane(rootPanel);
    }

    public static void main(String[] ignore){
        MainApp main = new MainApp();
        main.start();
    }
}
