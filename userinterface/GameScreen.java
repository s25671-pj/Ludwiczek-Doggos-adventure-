package userinterface;

import objectgame.Cloud;
import objectgame.DoggoCharacter;
import objectgame.Field;
import objectgame.IceCream;
import objectgame.Sun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends JPanel implements Runnable, KeyListener {

    public static final float GRAVITY = 1f;
    public static final float GROUND = 400;

    private DoggoCharacter doggoCharacter;
    private Thread thread;
    private Field field;
    private Cloud cloud;
    private IceCream iceream;
    private Sun sunShine;

    public GameScreen(){
        thread = new Thread(this);
        doggoCharacter = new DoggoCharacter();
        doggoCharacter.setX(50);
        doggoCharacter.setY(400);
        field = new Field(this);
        cloud = new Cloud();
        iceream = new IceCream();
        sunShine = new Sun();

    }
    public void startGame(){
        thread.start();
    }
    public void run(){
        while(true){

            try{
                doggoCharacter.update();
                field.update();
                sunShine.update();
                cloud.update();
                iceream.update();
                if(iceream.getBound().intersects(doggoCharacter.getBound())){
                    System.out.println("Wdepnął...");
                }
                repaint();
                Thread.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
    @Override
    public void paint(Graphics g){
        g.setColor(new Color(164, 253, 255));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawLine(0, (int)GROUND, getWidth(),(int)GROUND);
        g.setColor(new Color(166, 220, 69));
        g.fillRect(0,400, getWidth(), getHeight());
        sunShine.draw(g);
        cloud.draw(g);
        field.draw(g);
        doggoCharacter.draw(g);
        iceream.draw(g);
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