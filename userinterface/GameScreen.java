package userinterface;

import objectgame.DoggoCharacter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends JPanel implements Runnable, KeyListener {

    public static final float GRAVITY = 1f;
    public static final float GROUND = 500;

    private DoggoCharacter doggoCharacter;
    private Thread thread;

    public GameScreen(){
        thread = new Thread(this);
        doggoCharacter = new DoggoCharacter();
    }
    public void startGame(){
        thread.start();
    }
    public void run(){
        while(true){

            try{
                doggoCharacter.update();
                repaint();
                Thread.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
    @Override
    public void paint(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawLine(0, (int)GROUND, getWidth(),(int)GROUND);
        doggoCharacter.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        doggoCharacter.jump();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released");
    }
}