package interfaceUser;

import java.awt.Color;
import java.awt.Graphics;

import object.Hero;
import scenes.Jouer;

import static main.States.*;

public class ActionBar extends Bar{
    
    private Button menuButton;
    private Jouer jouer;
    private Button[] toursButtons;
    private Hero choosedHero;

    public ActionBar(int x,int y,int width,int height, Jouer jouer){
        super(x, y, width, height);
        this.jouer = jouer;
        initializeButton();
    }

    private void initializeButton(){
        menuButton = new Button("Menu", 2, 642, 100, 30);
        toursButtons = new Button[3];
        int w = 50;
        int h = 50;
        int xDepart =110;
        int yDepart = 650;
        int xSortie = (int)(w*1.1f);

        for (int i = 0 ; i < toursButtons.length ; i++){
            toursButtons[i] = new Button("", xDepart+xSortie*i, yDepart, w, h, i);
        }
    }

    private void afficheButton(Graphics graphics){
        menuButton.draw(graphics);
        for (Button button : toursButtons){
            //button.draw(graphics);

            //graphics.setColor();
            //graphics.fillRect(button.x, button.y, button.width, button.height);
            graphics.drawImage(jouer.getHeroManagement().getHeroimage()[button.getId()], button.x, button.y, button.width, button.height,null);
            afficheButton(graphics, button);
        }
    }

    public void affiche(Graphics graphics){
        graphics.setColor(new Color(55,8,8));
        graphics.fillRect(x, y, width, height);
        afficheButton(graphics);
    }

	public void mouseClicked(int x, int y) {
		if (menuButton.getRectangle().contains(x, y)){ 
			setStates(MENU);
        } else {
            for (Button button : toursButtons){
                if (button.getRectangle().contains(x,y)){
                    choosedHero = new Hero (0,0,-1,button.getId());
                    jouer.setChoosenHero(choosedHero);
                    return;
                }
            }
        }

	}


    public void mouseMoved(int x, int y) {
        for(Button button : toursButtons){
            button.setMouseOnIt(false);
        }
		menuButton.setMouseOnIt(false);
        if (menuButton.getRectangle().contains(x, y)){
			menuButton.setMouseOnIt(true);
        } else {
            for(Button button : toursButtons){
                if (button.getRectangle().contains(x, y)){
                    button.setMouseOnIt(true);
                    return;
                }
            }
        }

        
        
    }

	public void mousePressed(int x, int y) {
		for(Button button : toursButtons){
            button.setMousePressed(false);
        }
		menuButton.setMousePressed(false);
        if (menuButton.getRectangle().contains(x, y)){
			menuButton.setMousePressed(true);
        } else {
            for(Button button : toursButtons){
                if (button.getRectangle().contains(x, y)){
                    button.setMousePressed(true);
                    return;
                }
            }
        }

	}

	public void mouseReleased(int x, int y) {
		menuButton.resetBooleans();
        for(Button button : toursButtons){
            button.resetBooleans();
        }

    }

}
