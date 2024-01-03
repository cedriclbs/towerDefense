package scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import interfaceUser.Button;
import main.Game;
import static main.States.*;

public class Menu extends GameScene implements interfaceScenes {

    private Random random;
    private BufferedImage image;
    private ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
    private Button jouerButton;
    private Button quitterButton;
    private Button parametresButton;


    
    public Menu(Game game) {
        super(game);
        random = new Random();
        importImg();
        AfficheSprites();

        int widthForText = 150;
		int heightForText = widthForText / 3;
		int x = 640 / 2 - widthForText / 2;
		int y = 150;
		int yOffset = 100;

        jouerButton = new Button("Jouer", x, y, widthForText, heightForText);
        quitterButton = new Button("Quitter",x, y + yOffset * 2, widthForText, heightForText);
        parametresButton = new Button("Paramètres",x, y + yOffset, widthForText, heightForText);


    }

   

    @Override
    public void render(Graphics graphics) {
        jouerButton.draw(graphics);
        quitterButton.draw(graphics);
        parametresButton.draw(graphics);


        /*
         * for(int x=0; x<20 ; x++){
            for(int y=0; y<20 ; y++){
                graphics.drawImage(sprites.get(getRndInt()), x*32, y*32, null);
            }
        }
         */
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

    @Override
    public void mouseClicked(int x, int y) {
        if(jouerButton.getRectangle().contains(x,y)){
            setStates(JOUER);
        }
        else if (quitterButton.getRectangle().contains(x,y)){
            System.exit(0);
        } 
        else if (parametresButton.getRectangle().contains(x,y)){
            setStates(PARAMETRES);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        jouerButton.setMouseOnIt(false);
        quitterButton.setMouseOnIt(false);
        parametresButton.setMouseOnIt(false);

        if(jouerButton.getRectangle().contains(x,y)){
            jouerButton.setMouseOnIt(true);
        }
        else if (quitterButton.getRectangle().contains(x,y)){
            quitterButton.setMouseOnIt(true);
        } 
        else if (parametresButton.getRectangle().contains(x,y)){
            parametresButton.setMouseOnIt(true);
        }
    }


    @Override
    public void mousePressed(int x, int y) {
        if(jouerButton.getRectangle().contains(x,y)){
            jouerButton.setMousePressed(true);
        }
        else if(quitterButton.getRectangle().contains(x,y)){
            quitterButton.setMousePressed(true);
        }
        else if(parametresButton.getRectangle().contains(x,y)){
            parametresButton.setMousePressed(true);
        }      
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        jouerButton.resetBooleans();
        quitterButton.resetBooleans();
        parametresButton.resetBooleans();

    }
    
}
