package scenes;

import static helper.Constante.Images.HERBE_IMAGE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Monster.Monstres;
import management.WaveManagement;
import helper.Sauvegarde;
import interfaceUser.ActionBar;
import main.Game;
import management.HeroManagement;
import management.MissileManagement;
import management.MonsterManagement;
import object.Hero;
import object.Point;

public class Jouer extends GameScene implements interfaceScenes {


    private int[][] niveau;
    private ActionBar bottomBar;
    private int xMoved, yMoved; 
    private MonsterManagement monsterManagement;
    private HeroManagement heroManagement;
    private MissileManagement missileManagement;
    private Point start, end;
    private Hero choosedHero;
    private WaveManagement waveManagement;
    private Difficulty currentDifficulty = Difficulty.FACILE;
    private int OrTick;
    
    public enum Difficulty {
        FACILE, MOYEN, DIFFICILE, MARATHON;
    }

    public Jouer(Game game) {
        super(game);
        chargerNivParDefault();
        bottomBar = new ActionBar(0,640,640,160,this);
        monsterManagement = new MonsterManagement(this, start, end);
        heroManagement = new HeroManagement(this);
        missileManagement = new MissileManagement(this);
        waveManagement = new WaveManagement(this,currentDifficulty);
;   }

    public void updateWaveManagement() {
        this.waveManagement = new WaveManagement(this, currentDifficulty);
    }

    public void setDifficulty(Difficulty difficulty) {
        this.currentDifficulty = difficulty;
    }

    public Difficulty getCurrentDifficulty() {
        return this.currentDifficulty;
    }

    public void reset(Difficulty difficulty){
        chargerNivParDefault();

        xMoved = 0;
        yMoved = 0;
        choosedHero = null;

        heroManagement.reset();
        monsterManagement.reset();
        missileManagement.reset();
        waveManagement.reset(difficulty);
        bottomBar.resetAll();
        
    }

    @Override
    public void render(Graphics graphics) {
        ChargerNiveau(graphics);
        bottomBar.affiche(graphics);
        monsterManagement.affiche(graphics);
        heroManagement.affiche(graphics);
        missileManagement.affiche(graphics);
        
        afficheChoosedHero(graphics);
        afficheContourHero(graphics);

        afficheInfosWave(graphics);
    }

    private void chargerNivParDefault() {
        niveau = Sauvegarde.getNiveau("Nouveau_niveau");
        ArrayList<Point> nivpoints = Sauvegarde.getNiveauPoint("Nouveau_niveau");
        start = nivpoints.get(0);
        end = nivpoints.get(1);
    }

    public MonsterManagement getMonsterManagement() {
        return monsterManagement;
    }


    public HeroManagement getHeroManagement() {
        return heroManagement;
    }
    
    public void setNiveau(int[][] niveau) {
        this.niveau=niveau;
    }
    
    public void update(){
        waveManagement.update();

        OrTick++;
        if(OrTick %(60*4)== 0){
            bottomBar.ajouteOr(1);
        }

        if (monstresMorts()){
            if (EstEncoreDeWaves()){
                waveManagement.startWaveManagementTimer();
                if (tempsFiniPourWave()){
                    waveManagement.incrementeIndexWave();
                    monsterManagement.getMonstres().clear();
                    waveManagement.resetIndexMonstre();
                }
            }
        }

        if(EstTempsPourNvMonstre()){
            afficheSpawnMonstre();
        }
        monsterManagement.update();
        heroManagement.update();
        missileManagement.update();
    }

    private boolean tempsFiniPourWave() {
        return waveManagement.tempsFiniPourWave();
    }


    private boolean EstEncoreDeWaves() {
        return waveManagement.EstEncoreDeWaves();
    }

    private boolean monstresMorts() {

        if(waveManagement.placeDispoPourMonstre()){
            return false;
        }

        for (Monstres m : monsterManagement.getMonstres()){
            if(m.estVivant()){
                return false;
            }

        }
        return true;
    }


    private void afficheInfosWave(Graphics graphics) {
        
    }

    private void afficheSpawnMonstre() {
        monsterManagement.afficheSpawnMonstre(waveManagement.getMonstreSuivant());
    }

    private boolean EstTempsPourNvMonstre() {
        if(this.waveManagement.EstTempsPourNvMonstre()){
            if (this.waveManagement.placeDispoPourMonstre()) {
                return true;
            }
        }
        return false;
    }

    private void afficheContourHero(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawRect(xMoved, yMoved, 32, 32);
    }


    private void afficheChoosedHero(Graphics graphics) {
        if (choosedHero != null){
            graphics.drawImage(heroManagement.getHeroimage()[choosedHero.getHeroType()], xMoved, yMoved,game);
        }
    }


    private void ChargerNiveau(Graphics graphics) {
        for(int y=0; y<niveau.length; y++) {
            for(int x=0; x<niveau[y].length;x++){
                int id = niveau[y][x];
                graphics.drawImage(getSprite(id),x*32,y*32,null);
            }   
        }
    }

    private BufferedImage getSprite(int spriteid){
        return game.getImageManagement().getSprite(spriteid);
    }

    public int getImageType(int x, int y){
        int xTemp = x / 32;
		int yTemp = y / 32;
		
		if(xTemp < 0 || xTemp > 19)
			return 0;
		if(yTemp < 0 || yTemp > 19)
			return 0;
            
        int id = niveau[y/32][x/32];
        return game.getImageManagement().getImage(id).getImageType();
    }


    @Override
	public void mouseClicked(int x, int y) {
        if(y>=640){
            bottomBar.mouseClicked(x, y);
        }else{
            //monsterManagement.AjouterMonstres(x, y,0);
            if(this.choosedHero!=null && EstSurHerbe(xMoved,yMoved)){
                if(getHeroAt(xMoved,yMoved)==null){
                    heroManagement.ajouteHero(choosedHero, xMoved, yMoved);
                    EnleverOr(choosedHero.getHeroType());
                    choosedHero = null;
                }
            }
            else{
                Hero h = getHeroAt(xMoved,yMoved);
                bottomBar.AffichageHero(h);
            }
        }
	}

    private void EnleverOr(int heroType) {
        bottomBar.payerHero(heroType);
    }

    public WaveManagement getWaveManagement() {
        return waveManagement;
    }


    public void setWaveManagement(WaveManagement waveManagement) {
        this.waveManagement = waveManagement;
    }

    private Hero getHeroAt(int x, int y) {
        return heroManagement.getHeroAt(x, y);
    }


    private boolean EstSurHerbe(int x, int y) {
        return game.getImageManagement().getImage(niveau[y/32][x/32]).getImageType()==HERBE_IMAGE;
    }

    public void OrPourJoueur(int typeDeMonstre){
        System.out.println(helper.Constante.Monstres.getOrMonstres(typeDeMonstre));
        bottomBar.ajouteOr(helper.Constante.Monstres.getOrMonstres(typeDeMonstre));
    }

    @Override
	public void mouseMoved(int x, int y) {
        if(y>=640){
            bottomBar.mouseMoved(x, y);
        } else {
            xMoved = (x/32)*32;
            yMoved = (y/32)*32;
        }

	}

	@Override
	public void mousePressed(int x, int y) {
        if(y>=640){
            bottomBar.mousePressed(x, y);
        }
	}

    public void keyPressed (KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
            choosedHero = null;
        }
    }

	@Override
	public void mouseReleased(int x, int y) {
        bottomBar.mouseReleased(x, y);
    }

	@Override
	public void mouseDragged(int x, int y) {

	}


    public void setChoosenHero(Hero choosedHero) {
        this.choosedHero = choosedHero;
    }


    public void TireSurMonstre(Hero h, Monstres m) {
        missileManagement.NouveauMissile(h, m);
    } 

}
