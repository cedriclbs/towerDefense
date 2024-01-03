package helper;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Sauvegarde {

    public static BufferedImage getSpriteAtlas(){

        BufferedImage image = null;
		InputStream is = Sauvegarde.class.getClassLoader().getResourceAsStream("spriteatlas.png");
        
		try {
			image = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return image;
    }
    
    
    
}
