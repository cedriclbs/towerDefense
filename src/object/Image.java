package object;

import java.awt.image.BufferedImage;

public class Image {
    private BufferedImage sprite;
    private int id;
    private String nom;

    public Image(BufferedImage sprite, int id, String nom){
        this.sprite = sprite;
        this.id = id;
        this.nom = nom;

    }

    public BufferedImage getSprite(){
        return sprite;
    }

    public int getId(){
        return id;
    }
    
    public String getNom(){
        return nom;
    }    
}
