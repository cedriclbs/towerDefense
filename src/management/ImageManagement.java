package management;

import java.util.ArrayList;

import helper.Sauvegarde;
import object.Image;
import java.awt.image.BufferedImage;

public class ImageManagement {

    public Image GRASS,WATER,ROAD;
    public BufferedImage Atlas;
    public ArrayList<Image> Images = new ArrayList<>();
    
    public ImageManagement(){
        ChargementAtlas();
        CreationDImage();
    }

    private void CreationDImage() {
        Images.add(GRASS = new Image(getSprite(8, 1)));
        Images.add(WATER = new Image(getSprite(0, 6)));
        Images.add(ROAD = new Image(getSprite(9, 0)));

    }

    private void ChargementAtlas() {
        Atlas = Sauvegarde.getSpriteAtlas();
    }

    public BufferedImage getSprite(int id){
        return Images.get(id).getSprite();
    }

    private BufferedImage getSprite(int x, int y){
        return Atlas.getSubimage(x*32, y*32, 32, 32);
    }

    
}
