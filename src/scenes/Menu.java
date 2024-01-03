package scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import main.Game;

public class Menu extends GameScene implements interfaceScenes {

    private Random random;
    private BufferedImage image;
    private ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
    
    public Menu(Game game) {
        super(game);
        random = new Random();
        importImg();
        AfficheSprites();
        //TODO Auto-generated constructor stub
    }

    @Override
    public void render(Graphics graphics) {
        for(int x=0; x<20 ; x++){
            for(int y=0; y<20 ; y++){
                graphics.drawImage(sprites.get(getRndInt()), x*32, y*32, null);
            }
        }
    }

    

    private void importImg() {

		InputStream is = getClass().getResourceAsStream("/spriteatlas.png");

		try {
			image = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    private void AfficheSprites() {
        for(int y = 0; y < 10; y++){
            for(int x = 0; x < 10; x++){
                sprites.add(image.getSubimage(x*32, y*32, 32, 32));
                
            }
        }

    }

    private int getRndInt(){
        return random.nextInt(100);
    }
    
    private Color getRndColor(){
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }

    
}
