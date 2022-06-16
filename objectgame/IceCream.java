package objectgame;

import others.Resource;
import java.awt.*;
import java.awt.image.BufferedImage;

public class IceCream {


    private BufferedImage image;
    private int posX, posY;
    private Rectangle box;

    public IceCream(){
        image = Resource.getResourceImage("data/kupka1.png");
        posX = 400;
        posY = 355;
        box = new Rectangle();
    }

    public void update(){

        posX -= 2;
        box.x = posX;
        box.y = posY;
        box.width = image.getWidth();
        box.height = image.getHeight();
    }

    public Rectangle getBound(){
        return box;
    }

    public void draw (Graphics g){
            g.drawImage(image, posX, posY,null);

    }
}
