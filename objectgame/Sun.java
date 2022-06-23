package objectgame;

import others.Animation;
import others.Resource;

import java.awt.*;

public class Sun {

    private final int posX, posY;
    private final Animation sunShine;

    public Sun() {
        sunShine = new Animation(200);
        sunShine.addFrame(Resource.getResourceImage("data/sun1.png"));
        sunShine.addFrame(Resource.getResourceImage("data/sun2.png"));
        sunShine.addFrame(Resource.getResourceImage("data/sun3.png"));
        posX = 550;
        posY = 35;

    }

    public void update(){
        sunShine.update();

    }

    public void draw(Graphics g){
        g.drawImage(sunShine.getFrame(), posX, posY, null);
    }
}