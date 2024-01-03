package scenes;


import java.awt.Graphics;

import helper.NiveauConstruction;
import main.Game;
import management.ImageManagement;

public class Jouer extends GameScene implements interfaceScenes {
    private int[][] niveau;
    private ImageManagement imageManagement;

    public Jouer(Game game) {
        super(game);
        niveau = NiveauConstruction.getNiveauData();
        imageManagement = new ImageManagement();
    }

    @Override
    public void render(Graphics graphics) {
        for(int y=0; y<niveau.length; y++) {
            for(int x=0; x<niveau[y].length;x++){
                int id = niveau[y][x];
                graphics.drawImage(imageManagement.getSprite(id),x*32,y*32,null);
            }   
        }
    }
    
}
