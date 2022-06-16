package objectgame;

import others.Animation;
import others.Resource;

import java.awt.*;

public class Sun {

    private int posX, posY;
    private Animation sunShine;

    public Sun() {
        sunShine = new Animation(200);
        sunShine.addFrame(Resource.getResourceImage("data/sun1.png"));
        sunShine.addFrame(Resource.getResourceImage("data/sun2.png"));
        sunShine.addFrame(Resource.getResourceImage("data/sun3.png"));
        posX = 600;
        posY = 50;

    }

    public void update(){
        sunShine.update();

    }

    public void draw(Graphics g){
        g.drawImage(sunShine.getFrame(), posX, posY, null);
    }
}
