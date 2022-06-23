package objectgame;

import others.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Cloud {

    private final BufferedImage cloudImage;
    private final List<Cloudy> cloudies;
    public Cloud(){
        cloudImage = Resource.getResourceImage("data/cloud.png");
        cloudies = new ArrayList<>();

        Cloudy cloudy1 = new Cloudy();
        cloudy1.posX = 80;
        cloudy1.posY = 60;
        cloudies.add(cloudy1);

        cloudy1 = new Cloudy();
        cloudy1.posX = 250;
        cloudy1.posY = 85;
        cloudies.add(cloudy1);

        cloudy1 = new Cloudy();
        cloudy1.posX = 430;
        cloudy1.posY = 30;
        cloudies.add(cloudy1);

        cloudy1 = new Cloudy();
        cloudy1.posX = 590;
        cloudy1.posY = 40;
        cloudies.add(cloudy1);

        cloudy1 = new Cloudy();
        cloudy1.posX = 790;
        cloudy1.posY = 100;
        cloudies.add(cloudy1);

    }

    public void update(){

        for(Cloudy cloudy : cloudies){
            cloudy.posX --;
        }

        Cloudy fCloud = cloudies.get(0);
        if(fCloud.posX + cloudImage.getWidth() < 0){

            fCloud.posX = 800;
            cloudies.remove(fCloud);
            cloudies.add(fCloud);

        }
    }

    public void draw (Graphics g){
        for(Cloudy cloudy : cloudies) {
            g.drawImage(cloudImage, (int) cloudy.posX, (int) cloudy.posY, null);
        }
    }

    private static class Cloudy {
        float posX;
        float posY;
    }

}
