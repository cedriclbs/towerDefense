package object;

import java.awt.image.BufferedImage;

public class Image {
    private BufferedImage sprite;

    public Image(BufferedImage sprite){
        this.sprite = sprite;

    }

    public BufferedImage getSprite(){
        return sprite;
    }
    
}
