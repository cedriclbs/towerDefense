package scenes;


import java.awt.Color;
import java.awt.Graphics;

import helper.NiveauConstruction;
import helper.Sauvegarde;
import interfaceUser.Bar;
import main.Game;
import management.ImageManagement;
import object.Image;

import static main.States.*;



public class Jouer extends GameScene implements interfaceScenes {
    private int[][] niveau;
    private ImageManagement imageManagement;
    private Bar bottomBar;
    private Image choosedImage;
    private int xMoved, lastImageX;
    private int yMoved, lastImageY;
    private int lastImageId;
    private boolean afficheChoosen;

    public Jouer(Game game) {
        super(game);
        niveau = NiveauConstruction.getNiveauData();
        imageManagement = new ImageManagement();
        bottomBar = new Bar(0,640,640,100,this);
        //Sauvegarde.CreationOfFile();
        //Sauvegarde.UpdateFile();
        //Sauvegarde.LectureFile();
        creationNivParDefault();
    }

    private void creationNivParDefault() {
        int[] arr = new int[400];
        for(int i=0; i<arr.length; i++){
            arr[i] = 0;
        }

        Sauvegarde.CreationNiveau("Nouveau niveau", arr);
    }

    @Override
    public void render(Graphics graphics) {
        for(int y=0; y<niveau.length; y++) {
            for(int x=0; x<niveau[y].length;x++){
                int id = niveau[y][x];
                graphics.drawImage(imageManagement.getSprite(id),x*32,y*32,null);
            }   
        }
        bottomBar.affiche(graphics);
        afficheImageChoisies(graphics);

    }

    private void afficheImageChoisies(Graphics graphics) {
        if (choosedImage !=null){
            if (afficheChoosen){
                graphics.drawImage(choosedImage.getSprite(), xMoved, yMoved, 32, 32, null);
            }
        }
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


    public ImageManagement getImageManagement() {
        return imageManagement;
    }

    public void setChoosenImage (Image image){
        this.choosedImage=image;
        afficheChoosen = true;
    }

    @Override
	public void mouseClicked(int x, int y) {
        if(y>=640){
            bottomBar.mouseClicked(x, y);
        } else {
            updateImage(xMoved,yMoved);
        }

	}


    @Override
	public void mouseMoved(int x, int y) {
        if(y>=640){
            bottomBar.mouseMoved(x, y);
            afficheChoosen = false;
        } else {
            xMoved = (x/32)*32;
            yMoved = (y/32)*32;
            afficheChoosen = true;
        }

	}

	@Override
	public void mousePressed(int x, int y) {
        if(y>=640){
            bottomBar.mousePressed(x, y);
        } else {
            updateImage(xMoved,yMoved);
        }

	}

	@Override
	public void mouseReleased(int x, int y) {
        if(y>=640){
            bottomBar.mouseReleased(x, y);

	    }
    }

	@Override
	public void mouseDragged(int x, int y) {
		if(y<640){
            updateImage(x,y);
	    }
	}    
    
}
