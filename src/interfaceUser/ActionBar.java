package interfaceUser;

import java.awt.Color;
import java.awt.Graphics;
import scenes.Jouer;

import static main.States.*;

public class ActionBar extends Bar{
    
    private Button menuButton;
    private Jouer jouer;


    public ActionBar(int x,int y,int width,int height, Jouer jouer){
        super(x, y, width, height);
        this.jouer = jouer;
        initializeButton();
    }

    private void initializeButton(){
        menuButton = new Button("Menu", 2, 642, 100, 30);
    }

    private void afficheButton(Graphics graphics){
        menuButton.draw(graphics);
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

}
