package interfaceUser;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import object.Image;
import scenes.Jouer;

import static main.States.*;
import java.awt.image.BufferedImage;

public class Bar {
    
    private int x,y,width,height;
    private Button menuButton;
    private Jouer jouer;
    private ArrayList<Button> imageButton = new ArrayList<> ();

    public Bar(int x,int y,int width,int height, Jouer jouer){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.jouer = jouer;

        initializeButton();
    }

    private void initializeButton(){
        menuButton = new Button("Menu", 2, 642, 100, 30);

        int w = 50;
        int h = 50;
        int xDepart =110;
        int yDepart = 650;
        int xoffset = (int)(w*1.1f);
        int i =0;

        for(Image image : jouer.getImageManagement().Images){
            imageButton.add(new Button(image.getNom(), xDepart + xoffset*i, yDepart, w, h,i));
            i++;
        }
    }

    private void afficheButton(Graphics graphics){
        menuButton.draw(graphics);
        afficheImageButton(graphics);
    }

    private void afficheImageButton(Graphics graphics){ 
        for (Button button : imageButton) {
            graphics.drawImage(getButtonImg(button.getId()),button.x, button.y, button.width,button.height,null);
        }

    }

    public void affiche(Graphics graphics){
        graphics.setColor(new Color(220,123,15));
        graphics.fillRect(x, y, width, height);
        afficheButton(graphics);
    }

	public void mouseClicked(int x, int y) {
		if (menuButton.getRectangle().contains(x, y)){ 
			setStates(MENU);
        }

	}

	public void mouseMoved(int x, int y) {
		menuButton.setMouseOnIt(false);
		if (menuButton.getRectangle().contains(x, y)){
			menuButton.setMouseOnIt(true);
        }

	}

	public void mousePressed(int x, int y) {
		if (menuButton.getRectangle().contains(x, y)){
			menuButton.setMousePressed(true);
        }

	}

	public void mouseReleased(int x, int y) {
		menuButton.resetBooleans();
    }

    public BufferedImage getButtonImg(int id){
        return jouer.getImageManagement().getSprite(id);
    }
}
