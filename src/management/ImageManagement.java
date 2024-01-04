package management;

import java.util.ArrayList;

import helper.Sauvegarde;
import object.Image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageManagement {

    public Image HERBE,EAU,ROUTE,
    EAU_COIN_1,EAU_COIN_2,EAU_COIN_3,EAU_COIN_4, EAU_COIN_5,
    ROUTE_1, ROUTE_2, ROUTE_3, ROUTE_4, ROUTE_5,
    ILE_1, ILE_2, ILE_3, ILE_4;
    public BufferedImage Atlas;
    public ArrayList<Image> Images = new ArrayList<>();
    
    public ImageManagement(){
        ChargementAtlas();
        CreationDImage();
    }

    private void CreationDImage() {
        int id =0;
        Images.add(HERBE = new Image(getSprite(9, 0),id++,"Herbe"));
        Images.add(EAU = new Image(getSprite(0, 0),id++,"Eau"));
        Images.add(ROUTE = new Image(getSprite(8, 0),id++,"Route"));

        Images.add(EAU_COIN_1 = new Image(afficheImage(getImages(0,0,5, 0)),id++,"Eau_COIN_1"));
        Images.add(EAU_COIN_2 = new Image(afficheImageRot(getImages(0,0,5, 0),90,1),id++,"Eau_COIN_2"));
        Images.add(EAU_COIN_3 = new Image(afficheImageRot(getImages(0, 0, 6, 0), 90, 1), id++, "Eau_COIN_3"));
        Images.add(EAU_COIN_4 = new Image(afficheImageRot(getImages(0, 0, 6, 0), 180, 1), id++, "Eau_COIN_4"));
        Images.add(EAU_COIN_5 = new Image(afficheImageRot(getImages(0, 0, 6, 0), 270, 1), id++, "Eau_COIN_5"));
       
        Images.add(ROUTE_1 = new Image(rotateSprite(getSprite(8, 0), 90), id++, "Route_1"));
        Images.add(ROUTE_2 = new Image(getSprite(7, 0), id++, "Route_2"));
        Images.add(ROUTE_3 = new Image(rotateSprite(getSprite(7, 0), 90), id++, "Route_3"));
        Images.add(ROUTE_4 = new Image(rotateSprite(getSprite(7, 0), 180), id++, "Route_4"));
        Images.add(ROUTE_5 = new Image(rotateSprite(getSprite(7, 0), 270), id++, "Route_5"));

        Images.add(ILE_1 = new Image(afficheImage(getImages(0, 0, 4, 0)), id++, "Ile_1"));
        Images.add(ILE_2 = new Image(afficheImageRot(getImages(0, 0, 4, 0), 90, 1), id++, "Ile_2"));
        Images.add(ILE_3 = new Image(afficheImageRot(getImages(0, 0, 4, 0), 180, 1), id++, "Ile_3"));
        Images.add(ILE_4 = new Image(afficheImageRot(getImages(0, 0, 4, 0), 270, 1), id++, "Ile_4"));
   

    }


    private BufferedImage[] getImages (int x, int y, int xRotate, int yRotate){
        return new BufferedImage[] {
            getSprite(x,y), getSprite(xRotate, yRotate)
        };
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
