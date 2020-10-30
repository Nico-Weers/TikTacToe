package application;

import gui.UsernameGUI;
import interfaces.IRegisterGUI;

import javax.swing.JFrame;

public class MainApp {

    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_WIDTH = 400;

    JFrame frame = new JFrame("");

    public void start(){
        IRegisterGUI registerGUI = new UsernameGUI();
        registerGUI.initialize();
        configFrame();
        frame.setContentPane(registerGUI.getRootPanel());
    }

    private void configFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public static void main(String[] ignore){
        MainApp main = new MainApp();
        main.start();
    }
}
