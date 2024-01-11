package management;

import java.util.ArrayList;

import helper.Sauvegarde;
import object.Image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import static helper.Constante.Images.*;

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
        Images.add(HERBE = new Image(getSprite(9, 0),id++,HERBE_IMAGE));
        Images.add(EAU = new Image(getSprite(0, 0),id++,EAU_IMAGE));
        Images.add(ROUTE = new Image(getSprite(8, 0),id++,ROUTE_IMAGE));

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

    public Image getImage (int id){
        return Images.get(id);
    }


    public static BufferedImage rotateSprite (BufferedImage sprite, int angle){
        int width = sprite.getWidth();
        int height = sprite.getHeight();

        BufferedImage tempBI = new BufferedImage(width, height, sprite.getType());
        Graphics2D tempForRotation = tempBI.createGraphics(); 

        tempForRotation.rotate(Math.toRadians(angle),width/2,height/2);
        tempForRotation.drawImage(sprite, 0, 0, null);
        tempForRotation.dispose();

        return tempBI; //casting de Graphics2D en BufferedImage  -> impossible donc on passe par tempBI (voir docu)

    }




    public static BufferedImage afficheImage (BufferedImage []sprites){
        int width = sprites[0].getWidth();
        int height = sprites[0].getHeight();

        BufferedImage tempBI = new BufferedImage(width, height, sprites[0].getType());
        Graphics2D graphics2d = tempBI.createGraphics(); 

        for (BufferedImage sprite : sprites){
            graphics2d.drawImage(sprite, 0, 0, null);
        }

        graphics2d.dispose();

        return tempBI;

    }


    
    public static BufferedImage afficheImageRot (BufferedImage []sprites, int angle, int rot){
        int width = sprites[0].getWidth();
        int height = sprites[0].getHeight();

        BufferedImage tempBI = new BufferedImage(width, height, sprites[0].getType());
        Graphics2D graphics2d = tempBI.createGraphics(); 


        for (int i = 0 ; i <sprites.length; i++){
            if (rot==i){
                graphics2d.rotate(Math.toRadians(angle),width/2,height/2);
            }
            graphics2d.drawImage(sprites[i],0,0,null);
            if (rot==i){
                graphics2d.rotate(-angle,width/2,height/2);
            }
        }

        graphics2d.dispose();
        return tempBI;


    }








    
}
