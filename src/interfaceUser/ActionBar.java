package interfaceUser;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;

import helper.Constante.Heros;
import management.WaveManagement;
import object.Hero;
import scenes.Jouer;

import static main.States.*;

public class ActionBar extends Bar{
    
    private Button menuButton;
    private Jouer jouer;
    private Button[] toursButtons;
    private Hero choosedHero;
    private Hero afficherHero;
    private DecimalFormat decimalFormat;

    public ActionBar(int x,int y,int width,int height, Jouer jouer){
        super(x, y, width, height);
        this.jouer = jouer;
        initializeButton();
        decimalFormat = new DecimalFormat("0.0");
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

    public void AffichageHero(Hero h){
        afficherHero = h;
    }

    private void afficheButton(Graphics graphics){
        menuButton.draw(graphics);
        for (Button button : toursButtons){
            graphics.drawImage(jouer.getHeroManagement().getHeroimage()[button.getId()], button.x, button.y, button.width, button.height,null);
            afficheButton(graphics, button);
        }
    }

    public void affiche(Graphics graphics){
        graphics.setColor(new Color(55,8,8));
        graphics.fillRect(x, y, width, height);
        afficheButton(graphics);
        afficheAfficherHero(graphics);
        afficheInfosWave(graphics);
    }

	private void afficheInfosWave(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.setFont(new Font("LucidaSans", Font.BOLD, 20));
        afficheTempsRestantWaves(graphics);
        afficheInfosMonstresVivants(graphics);
        afficheInfosWaves(graphics);
        
    }

    private void afficheInfosWaves(Graphics graphics) {
        WaveManagement wM = jouer.getWaveManagement();
        graphics.drawString("Wave " + (wM.getIndexWave()+1) + " / " + wM.getListeWaves().size() , 425, 690);
    }

    private void afficheInfosMonstresVivants(Graphics graphics) {
        graphics.drawString("Monstres vivants : " + jouer.getMonsterManagement().getNbMonstresRestants(), 425, 730);
    }

    private void afficheTempsRestantWaves(Graphics graphics) {
        if (jouer.getWaveManagement().timerdeWaveOK()){
            graphics.drawString("Temps restant : " + decimalFormat.format(jouer.getWaveManagement().getTempsRestant()), 425, 660);
        }
    }

    private void afficheAfficherHero(Graphics graphics) {
        if(afficherHero != null){
            graphics.setColor(new Color(61,43,40));
            graphics.fillRect(410, 645, 220, 85);
            graphics.setColor(Color.black);
            graphics.drawRect(410, 645, 220, 85);
            graphics.drawRect(420, 650, 50, 50);
            graphics.drawImage(jouer.getHeroManagement().getHeroimage()[afficherHero.getHeroType()], 420, 650,50,50, null);
            graphics.setColor(Color.black);
            graphics.drawString(""+Heros.getNom(afficherHero.getHeroType()), 490, 660);
            graphics.drawString("ID:"+afficherHero.getId(), 490, 675);
            afficheContoursHeroChoisis(graphics);
            affichePorteeHero(graphics);
        }
    }

    private void affichePorteeHero(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        int porteeHero = (int)afficherHero.getPortee()*2;
        graphics.drawOval(afficherHero.getX()+16-porteeHero/2, afficherHero.getY()+16-porteeHero/2, porteeHero, porteeHero);

    }

    private void afficheContoursHeroChoisis(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.drawRect(afficherHero.getX(), afficherHero.getY(), 32, 32);
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
