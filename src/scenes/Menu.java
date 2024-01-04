package scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import interfaceUser.Button;
import main.Game;
import static main.States.*;

public class Menu extends GameScene implements interfaceScenes {

    private Random random;
    private Button jouerButton;
    private Button quitterButton;
    private Button parametresButton;
    private Button editButton;


    
    public Menu(Game game) {
        super(game);
        random = new Random();

        int widthForText = 150;
		int heightForText = widthForText / 3;
		int x = 640 / 2 - widthForText / 2;
		int y = 150;
		int yOffset = 100;

        jouerButton = new Button("Jouer", x, y, widthForText, heightForText);
        editButton = new Button("Edit", x, y+yOffset,widthForText,heightForText); 
        parametresButton = new Button("Paramètres",x, y + yOffset*2, widthForText, heightForText);
        quitterButton = new Button("Quitter",x, y + yOffset * 3, widthForText, heightForText);
    }

   

    @Override
    public void render(Graphics graphics) {
        jouerButton.draw(graphics);
        editButton.draw(graphics);
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
        else if(editButton.getRectangle().contains(x, y)){
            setStates(EDITER);
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
        else if(editButton.getRectangle().contains(x, y)){
            editButton.setMouseOnIt(true);
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
        else if(editButton.getRectangle().contains(x, y)){
            editButton.setMousePressed(true);
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

    @Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
	}    

    private void resetButtons() {
        jouerButton.resetBooleans();
        editButton.resetBooleans();
        quitterButton.resetBooleans();
        parametresButton.resetBooleans();

    }
    
}
