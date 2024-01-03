package management;

import java.util.ArrayList;

import helper.Sauvegarde;
import object.Image;
import java.awt.image.BufferedImage;

public class ImageManagement {

    public Image HERBE,EAU,ROUTE;
    public BufferedImage Atlas;
    public ArrayList<Image> Images = new ArrayList<>();
    
    public ImageManagement(){
        ChargementAtlas();
        CreationDImage();
    }

    private void CreationDImage() {
        int id =0;
        Images.add(HERBE = new Image(getSprite(8, 1),id++,"Herbe"));
        Images.add(EAU = new Image(getSprite(0, 6),id++,"Eau"));
        Images.add(ROUTE = new Image(getSprite(9, 0),id++,"Route"));

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
