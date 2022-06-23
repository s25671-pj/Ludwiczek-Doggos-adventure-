package others;

import java.util.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {

    private final List<BufferedImage> frames;
    private int frameIndex = 0;
    private final int dtime;
    private long ptime;

    public Animation(int dtime){
        this.dtime = dtime;
        frames = new ArrayList<>();

    }

    public void update(){
        if(System.currentTimeMillis() - ptime > dtime){
            frameIndex++;
            if(frameIndex >= frames.size()) {
                frameIndex = 0;
            }
                ptime = System.currentTimeMillis();

        }
    }

    public void addFrame(BufferedImage frame) {
        frames.add(frame);
    }

    public BufferedImage getFrame() {
        if(frames.size() > 0) {
            return frames.get(frameIndex);
        }
    return null;
    }

}
