package userinterface;

import objectgame.*;
import others.Resource;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.Color.BLACK;

public class GameScreen extends JPanel implements Runnable, KeyListener {

    public static final int GAME_FIRST_STATE = 0;
    public static final int GAME_PLAY_STATE = 1;
    public static final int GAME_OVER_STATE = 2;
    public static final float GRAVITY = 0.05f;
    public static final float GROUND = 400;

    private final DoggoCharacter doggoCharacter;
    private final Thread thread;
    private final Field field;
    private final Cloud cloud;
    private final Sun sunShine;
    private final Enemies enemies;
    private int score;

    private int gameState = GAME_FIRST_STATE;
    private final BufferedImage imageStart;
    private final BufferedImage imageGameOver;

    public GameScreen() {
        thread = new Thread(this);
        doggoCharacter = new DoggoCharacter();
        doggoCharacter.setX(50);
        doggoCharacter.setY(400);
        field = new Field(this);
        cloud = new Cloud();
        sunShine = new Sun();
        enemies = new Enemies(doggoCharacter, this);
        imageGameOver = Resource.getResourceImage("data/gameover.png");
        imageStart = Resource.getResourceImage("data/start.png");

    }

    public void startGame() {
        thread.start();
    }

    public void run() {
        while (true) {
            try {
                update();
                repaint();
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void audio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("data/AdventureTheme.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        if (gameState == GAME_PLAY_STATE) {
            clip.start();
        }
        if (gameState == GAME_OVER_STATE) {
            clip.stop();
            clip.setMicrosecondPosition(0);
        }

    }

    public void update() {
        switch (gameState) {
            case GAME_PLAY_STATE:
                doggoCharacter.update();
                field.update();
                sunShine.update();
                cloud.update();
                enemies.update();
                if (!doggoCharacter.getClean()) {
                    gameState = GAME_OVER_STATE;
                }
                break;
        }
    }

    public void incScore(int score) {
        this.score += score;

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(164, 253, 255));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(new Color(166, 220, 69));
        g.fillRect(0, 400, getWidth(), getHeight());

        switch (gameState) {
            case GAME_FIRST_STATE:
                g.drawImage(imageStart, 0, 0, null);
                break;
            case GAME_PLAY_STATE:
                sunShine.draw(g);
                cloud.draw(g);
                field.draw(g);
                doggoCharacter.draw(g);
                enemies.draw(g);
                g.setColor(BLACK);
                g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                g.drawString("WYNIK: " + (score), 640, 30);
                break;
            case GAME_OVER_STATE:
                g.drawImage(imageGameOver, 0, 0, null);
                g.setColor(BLACK);
                g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                g.drawString("WYNIK: " + (score), 640, 30);
                break;
        }
    }

    private void newGame() {
        doggoCharacter.setClean(true);
        doggoCharacter.setX(50);
        doggoCharacter.setY(400);
        enemies.newGame();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                if (gameState == GAME_FIRST_STATE) {
                    gameState = GAME_PLAY_STATE;
                    try {
                        audio();
                    } catch (UnsupportedAudioFileException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (LineUnavailableException ex) {
                        ex.printStackTrace();
                    }
                } else if (gameState == GAME_PLAY_STATE) {
                    doggoCharacter.jump();
                } else if (gameState == GAME_OVER_STATE) {
                    score = 0;
                    newGame();
                    gameState = GAME_PLAY_STATE;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + e.getKeyCode());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}