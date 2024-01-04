package scenes;

import java.awt.Graphics;

import helper.Sauvegarde;
import interfaceUser.ToolBar;
import main.Game;
import object.Image;
import java.awt.image.BufferedImage;

public class Edit extends GameScene implements interfaceScenes{
    private int[][] niveau;
    private Image choosedImage;
    private int xMoved, lastImageX;
    private int yMoved, lastImageY;
    private int lastImageId;
    private boolean afficheChoosen;
    private ToolBar toolBar;

    public Edit(Game game) {
        super(game);
        chargerNivParDefault();
        toolBar =new ToolBar(0,640,640,100,this);
    }

    private void chargerNivParDefault() {
        niveau = Sauvegarde.getNiveau("Nouveau_niveau");
    }
    

    @Override
    public void render(Graphics graphics) {
        ChargerNiveau(graphics);
        toolBar.affiche(graphics);
        afficheImageChoisies(graphics);
      
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
    private void afficheImageChoisies(Graphics graphics) {
        if (choosedImage !=null){
            if (afficheChoosen){
                graphics.drawImage(choosedImage.getSprite(), xMoved, yMoved, 32, 32, null);
            }
        }
    }

    public void sauvegarderNiveau() {
        Sauvegarde.SauvNiveau("Nouveau_niveau", niveau);
        game.getJouer().setNiveau(niveau);
    }

    public void setChoosenImage (Image image){
        this.choosedImage=image;
        afficheChoosen = true;
    }

    private void updateImage(int x, int y) {
        if (choosedImage != null){

            int tempY = y/32;
            int tempX = x/32;

            if (lastImageId == choosedImage.getId() && lastImageX == tempX && lastImageY == tempY){
                return;
            }
            lastImageX = tempX;
            lastImageY = tempY;
            lastImageId = choosedImage.getId();
            this.niveau[tempY][tempX] = choosedImage.getId();
        }
    }

    @Override
    public void mouseClicked(int x, int y) {
        if(y>=640){
            toolBar.mouseClicked(x, y);
        } else {
            updateImage(xMoved,yMoved);
        }
    }    

    @Override
    public void mouseMoved(int x, int y) {
        if(y>=640){
            toolBar.mouseMoved(x, y);
            afficheChoosen = false;
        } else {
            afficheChoosen = true;
            xMoved = (x/32)*32;
            yMoved = (y/32)*32;
           
        }
       
    }

    @Override
    public void mousePressed(int x, int y) {
       
    }

    @Override
    public void mouseReleased(int x, int y) {
    }  

    @Override
    public void mouseDragged(int x, int y) {
        if(y>640){  

        }else{
            updateImage(x,y);
	    }
    }    
    
    
}
