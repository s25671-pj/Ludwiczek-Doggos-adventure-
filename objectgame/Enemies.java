package objectgame;

import others.Resource;
import userinterface.GameScreen;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemies {

    private final List<Enemy> enemies;
    private final Random random;

    private final BufferedImage imageKupka1, imageKupka2, imageKupka3;
    private final DoggoCharacter doggoCharacter;
    private final GameScreen gameScreen;

    public Enemies(DoggoCharacter doggoCharacter, GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.doggoCharacter = doggoCharacter;
        enemies = new ArrayList<>();
        imageKupka1 = Resource.getResourceImage("data/kupka1.png");
        imageKupka2 = Resource.getResourceImage("data/kupka2.png");
        imageKupka3 = Resource.getResourceImage("data/kupka3.png");
        random = new Random();
        enemies.add(getRandomIceCream());

    }

    public void update() {

        for (Enemy e : enemies) {
            e.update();
            if(e.isOver() && !e.isScoreHigher()){
                gameScreen.incScore(20);
                e.setIsScoreHigher(true);
            }
            if(e.getBound().intersects(doggoCharacter.getBound())){
                doggoCharacter.setClean(false);

            }
        }
        Enemy fEnemy = enemies.get(0);
        if (fEnemy.AnotherOne()) {
            enemies.remove(fEnemy);
            enemies.add(getRandomIceCream());
        }

    }

    public void draw(Graphics g) {

        for (Enemy e : enemies) {
            e.draw(g);
        }
    }

    public void newGame(){
        enemies.clear();
        enemies.add(getRandomIceCream());

    }

    private IceCream getRandomIceCream() {
        IceCream iceCream;
        iceCream = new IceCream(doggoCharacter);
        iceCream.setX(800);
        int kupki = 3;
        int kupki_random = random.nextInt(kupki);
        //int b = random.nextInt() < 3;

        switch (kupki_random) {
            case 0:
                iceCream.setImage(imageKupka2);
                break;
            case 1:
                iceCream.setImage(imageKupka3);
                break;
            case 2:
            iceCream.setImage(imageKupka1);
            break;
        }
    return iceCream;
    }
}