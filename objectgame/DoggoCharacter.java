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
    private final Animation doggoRun;
    private final Rectangle box;
    private boolean isClean = true;

    public DoggoCharacter() {
        doggoRun = new Animation(200);
        doggoRun.addFrame(Resource.getResourceImage("data/ludwiczek1.png"));
        doggoRun.addFrame(Resource.getResourceImage("data/ludwiczek2.png"));
        box = new Rectangle();
    }

    public void update() {
        doggoRun.update();
        if (y >= GROUND - doggoRun.getFrame().getHeight()) {
            speedY = 0;
            y = GROUND - doggoRun.getFrame().getHeight();
        } else {
            speedY += GRAVITY;
            y += speedY;
        }
        box.x = (int)x;
        box.y = (int)y;
        box.width = doggoRun.getFrame().getWidth();
        box.height = doggoRun.getFrame().getHeight();
    }


    public void draw(Graphics g){
        g.drawImage(doggoRun.getFrame(), (int)x, (int) y, null);
    }

    public void jump(){

        if( speedY == 0) {
            speedY = -4;
            y += speedY;
        }

    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Rectangle getBound() {
        return box;
    }

    public void setClean(boolean clean){
        isClean = clean;
    }

    public boolean getClean() {
        return isClean;
    }
}
