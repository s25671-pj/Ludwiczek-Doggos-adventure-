package objectgame;

import others.Resource;
import userinterface.GameScreen;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static userinterface.GameScreen.GROUND;

public class Field {

    private List<ImageField> listImage;
    private BufferedImage imageField1, imageField2;
    private Random random;

    public Field(GameScreen game) {
        random = new Random();
        imageField1 =Resource.getResourceImage("data/field1.png");
        imageField2 =Resource.getResourceImage("data/field2.png");
        listImage = new ArrayList<ImageField>();
        int nField = 888 / imageField1.getWidth() + 1;

        for(int i = 0; i < nField; i++){

            ImageField imageField = new ImageField();
            imageField.posX = (int) (i * imageField1.getWidth());
            imageField.image = getImageField();
            listImage.add(imageField);
        }
    }

    public void update(){

        for(ImageField imageField: listImage){
            imageField.posX -= 2;
        }
        ImageField fElement = listImage.get(0);
        if(fElement.posX + imageField1.getWidth() < 0){
            fElement.posX = listImage.get(listImage.size() - 1).posX + imageField1.getWidth();
            listImage.add(fElement);
            listImage.remove(0);


        }

    }

    public void draw(Graphics g){

        for(ImageField imageField:listImage){
            g.drawImage(imageField.image, imageField.posX, (int)GROUND - 110, null);
        }
    }

    private BufferedImage getImageField() {
        int i = random.nextInt(2);
        switch(i){
            case 0: return imageField1;
            case 1: return imageField2;
            default: return imageField2;
        }

    }


    private class ImageField {

        int posX;
        BufferedImage image;

    }

}
