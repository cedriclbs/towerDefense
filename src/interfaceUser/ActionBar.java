package interfaceUser;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;

import helper.Constante.Heros;
import management.WaveManagement;
import object.Hero;
import scenes.Jouer;
import scenes.Jouer.Difficulty;

import static main.States.*;

public class ActionBar extends Bar{
    
    public int getVies() {
        return vies;
    }

    private Button menuButton;
    private Jouer jouer;
    private Button[] toursButtons;
    private Hero choosedHero;
    private Hero afficherHero;
    private DecimalFormat decimalFormat;
    private int or = 90;
    private boolean montrePrixH;
    private int heroPrixType;
    private int vies = 20;

    public ActionBar(int x,int y,int width,int height, Jouer jouer){
        super(x, y, width, height);
        this.jouer = jouer;
        initializeButton();
        decimalFormat = new DecimalFormat("0.0");
    }

    // public ActionBar(int x, int y, int width, int height, NiveauFacile niveauFacile) {
    //     super(x, y, width, height);
    //     this.niveauFacile = niveauFacile;
    //     initializeButton();
    //     decimalFormat = new DecimalFormat("0.0");
    // }

    public void resetAll(){
        afficherHero = null;
        choosedHero = null;
        montrePrixH = false;
        heroPrixType = 0;
        vies = 20;
        or = 90;
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
        afficheViesRestantes(graphics);
        afficheNbOr(graphics);
        if(montrePrixH){
            afficherPrixHero(graphics);
        }
    }

	private void afficheViesRestantes(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawString("Vies restantes : " + vies, 110, 750);
    }

    private void afficherPrixHero(Graphics graphics) {
        graphics.setColor(new Color(61,43,40));
        graphics.fillRect(280, 650, 120, 50);
        graphics.setColor(Color.black);
        graphics.drawRect(280, 650, 120, 50);

        graphics.drawString("" + getPrixHeroNom(), 285, 670);
        graphics.drawString("Prix : " + getPrixHero() + " Or", 285, 695);

        if(PrixHeroSuperieurOr()){
            graphics.setColor(new Color(190,25,25));
            graphics.drawString("Trop cher !", 285, 725);
        }
    }

    private boolean PrixHeroSuperieurOr() {
        return getPrixHero()>or;
    }

    private int getPrixHero() {
        return helper.Constante.Heros.getHeroPrix(heroPrixType);
    }

    private String getPrixHeroNom() {
        return helper.Constante.Heros.getNom(heroPrixType);
    }


    private void afficheNbOr(Graphics graphics) {
        graphics.drawString("Or : "+ or, 110, 725);
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
        if(jouer.getCurrentDifficulty() == Difficulty.MARATHON){
            graphics.drawString("Vagues " + "infinies !", 410, 750);
        }else{
            graphics.drawString("Vagues : " + (wM.getIndexWave()+1) + " / " + wM.getListeWaves().size() , 410, 750);
        }
    }

    private void afficheInfosMonstresVivants(Graphics graphics) {
        graphics.drawString("Monstres vivants : " + jouer.getMonsterManagement().getNbMonstresRestants(), 410, 780);
    }

    private void afficheTempsRestantWaves(Graphics graphics) {
        if (jouer.getWaveManagement().timerdeWaveOK()){
            graphics.drawString("Temps restant : " + decimalFormat.format(jouer.getWaveManagement().getTempsRestant()), 110, 790);
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
            graphics.drawString("ID : " + afficherHero.getId(), 490, 680);
            graphics.drawString("Portée : "+(int)afficherHero.getPortee(), 490, 700);
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
                    if(!AssezOR(button.getId())){
                        return;
                    }
                    choosedHero = new Hero (0,0,-1,button.getId());
                    jouer.setChoosenHero(choosedHero);
                    return;
                }
            }
        }
    }


    private boolean AssezOR(int heroType) {
        return or >= helper.Constante.Heros.getHeroPrix(heroType);
    }

    public void mouseMoved(int x, int y) {
        menuButton.setMouseOnIt(false);
        montrePrixH = false;
        for(Button button : toursButtons){
            button.setMouseOnIt(false);
        }
        if (menuButton.getRectangle().contains(x, y)){
			menuButton.setMouseOnIt(true);
        } else {
            for(Button button : toursButtons){
                if (button.getRectangle().contains(x, y)){
                    button.setMouseOnIt(true);
                    montrePrixH = true;
                    heroPrixType = button.getId();
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

    public void payerHero(int heroType) {
        this.or -= helper.Constante.Heros.getHeroPrix(heroType);
    }

    public void ajouteOr(int orMonstres) {
        this.or += orMonstres;
    }

    public void enleverUneVie () {
        vies--;
        if (vies <= 0){
            setStates(GAMEOVER);
        }
    }


}
