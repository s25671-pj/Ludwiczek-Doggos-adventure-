package objectgame;

import others.Resource;
import java.awt.*;
import java.awt.image.BufferedImage;

public class IceCream extends Enemy{


    private BufferedImage image;
    private int posX, posY;
    private final Rectangle box;
    private final DoggoCharacter doggoCharacter;
    private boolean isScoreHigher = false;

    public IceCream(DoggoCharacter doggoCharacter){
        this.doggoCharacter = doggoCharacter;
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

    @Override
    public Rectangle getBound(){
        return box;
    }

    @Override
    public void draw (Graphics g){
            g.drawImage(image, posX, posY,null);

    }

    public void setX(int x){
        posX = x;
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }

    @Override
    public boolean AnotherOne(){
        return (posX + image.getWidth() < 3);

    }

    @Override
    public boolean isOver(){
        return (doggoCharacter.getX() > posX);
    }

    @Override
    public boolean isScoreHigher(){
        return isScoreHigher;
    }

    @Override
    public void setIsScoreHigher(boolean isScoreHigher){
        this.isScoreHigher = isScoreHigher;
    }
}
