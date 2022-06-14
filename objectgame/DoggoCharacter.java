package objectgame;

import others.Animation;
import others.Resource;

import java.awt.*;

import static userinterface.GameScreen.GRAVITY;
import static userinterface.GameScreen.GROUND;

public class DoggoCharacter {

    private float x = 0;
    private float y = 0;
    private float speedY = 0;
    private Animation doggoRun;

    public DoggoCharacter() {
        doggoRun = new Animation(200);
        doggoRun.addFrame(Resource.getResourceImage("data/ludwiczek1.png"));
        doggoRun.addFrame(Resource.getResourceImage("data/ludwiczek2.png"));
    }

    public void update() {
        doggoRun.update();
        if (y >= GROUND - doggoRun.getFrame().getHeight()) {
            speedY = 0;
            y = GROUND - doggoRun.getFrame().getHeight();
        } else {
            speedY += GRAVITY;
            y += GRAVITY;

        }
    }


    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.drawRect((int) x, (int) y, doggoRun.getFrame().getWidth(), doggoRun.getFrame().getHeight());
        g.drawImage(doggoRun.getFrame(), (int)x, (int) y, null);
    }

    public void jump(){
        speedY = -100;
        y += speedY;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
}
