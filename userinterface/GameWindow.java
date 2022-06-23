package userinterface;

import javax.swing.*;


public class GameWindow extends JFrame{

    public static final int SCREEN_WIDTH = 800;
    private final GameScreen gameScreen;

    public GameWindow() {
            super("Doggo the game");
            setSize(SCREEN_WIDTH, 500);
            setLocation(600,300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameScreen = new GameScreen();
            add(gameScreen);
            addKeyListener(gameScreen);
    }

    public void startGame(){
        gameScreen.startGame();

    }

    public static void main(String[] args) {
            GameWindow gw = new GameWindow();
            gw.setVisible(true);
            gw.startGame();
    }
}
