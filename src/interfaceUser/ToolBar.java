package interfaceUser;

import java.util.ArrayList;

import helper.Sauvegarde;

import java.awt.Color;
import object.Image;
import scenes.Edit;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import static main.States.*;

public class ToolBar  extends Bar{
    private Button menuButton, sauvegarderButton, startButton, endButton;
    private BufferedImage imgStart, imgEnd;
    private ArrayList<Button> imageButton = new ArrayList<> ();
    private Image choosedImage;
    private Edit edit;

    
    public ToolBar(int x, int y, int width, int height,Edit edit) {
        super(x, y, width, height);
        this.edit = edit;
        initializeImgButton();
        initializeButton();
    }

    private void initializeImgButton() {
        imgStart = Sauvegarde.getSpriteAtlas().getSubimage(7*32, 2*32, 32, 32);
        imgEnd = Sauvegarde.getSpriteAtlas().getSubimage(8*32, 2*32, 32, 32);
    }

    private void initializeButton(){
        menuButton = new Button("Menu", 2, 642, 100, 30);
        sauvegarderButton = new Button("Sauvegarder", 2, 674, 100, 30);

        int w = 50;
        int h = 50;
        int xDepart =110;
        int yDepart = 650;
        int xSortie = (int)(w*1.1f);
        int i=0;

        for(Image image : edit.getGame().getImageManagement().Images){
            imageButton.add(new Button(image.getNom(), xDepart + xSortie*i, yDepart, w, h,i));
            i++;
        }

        startButton = new Button("Start", xDepart, xSortie + yDepart,w,h,i++);
        endButton = new Button("End", xDepart+xSortie, xSortie + yDepart,w,h,i++);


    }

    private void sauvegarderNiveau() {
        edit.sauvegarderNiveau();
    }

    public void affiche(Graphics graphics){
        graphics.setColor(new Color(55,8,8));
        graphics.fillRect(x, y, width, height);
        afficheButton(graphics);
    }

    private void afficheButton(Graphics graphics){
        menuButton.draw(graphics);
        sauvegarderButton.draw(graphics);

        afficheButtonSupp(graphics,startButton,imgStart);
        afficheButtonSupp(graphics,endButton,imgEnd);

        /*
        startButton.draw(graphics);
        endButton.draw(graphics);
        */
        afficheImageButton(graphics);
        afficheImageChoisies(graphics);
    }







    private void afficheButtonSupp(Graphics graphics, Button startButton2, BufferedImage imgStart2) {
        graphics.drawImage(imgStart2, startButton2.x, startButton2.y, startButton2.width, startButton2.height, null);
        afficheButton(graphics, startButton2);

    }

    private void afficheImageChoisies(Graphics graphics) {
        if (choosedImage !=null){
            graphics.drawImage(choosedImage.getSprite(), 550, 650, 50, 50, null);
            graphics.setColor(Color.BLACK);
            graphics.drawRect(550, 650, 50, 50);
        }
    }

    private void afficheImageButton(Graphics graphics){ 
        for (Button button : imageButton) {
            graphics.drawImage(getButtonImg(button.getId()),button.x, button.y, button.width,button.height,null);
            afficheButton(graphics, button);
        }

    }

    public BufferedImage getButtonImg(int id){
        return edit.getGame().getImageManagement().getSprite(id);
    }

    public void mouseClicked(int x, int y) {
		if (menuButton.getRectangle().contains(x, y)){ 
			setStates(MENU);
        } else if (sauvegarderButton.getRectangle().contains(x,y)){
            sauvegarderNiveau();
        } else if (startButton.getRectangle().contains(x,y)){
            choosedImage = new Image(imgStart, -1, -1);
            edit.setChoosenImage(choosedImage);
        }
        else if (endButton.getRectangle().contains(x,y)){
            choosedImage = new Image(imgEnd, -2, -2);
            edit.setChoosenImage(choosedImage);
        }
        else {
            for (Button button : imageButton){
                if (button.getRectangle().contains(x,y)){
                    choosedImage = edit.getGame().getImageManagement().getImage(button.getId());
                    edit.setChoosenImage(choosedImage);
                    return;
                }
            }
        }
    }

    public void mouseMoved(int x, int y) {
		menuButton.setMouseOnIt(false);
        sauvegarderButton.setMouseOnIt(false);
        startButton.setMouseOnIt(false);
        endButton.setMouseOnIt(false);

        for (Button b : imageButton){
            b.setMouseOnIt(false);
        }


		if (menuButton.getRectangle().contains(x, y)){
			menuButton.setMouseOnIt(true);
        } 
        else if (sauvegarderButton.getRectangle().contains(x,y)){
            sauvegarderButton.setMouseOnIt(true);
        }
        else if (startButton.getRectangle().contains(x,y)){
            startButton.setMouseOnIt(true);
        }
        else if (endButton.getRectangle().contains(x,y)){
            endButton.setMouseOnIt(true);
        }
        else {
            for (Button button : imageButton){
                if (button.getRectangle().contains(x,y)){
                    button.setMouseOnIt(true);
                    return;
                }
            }
        }

	}

	public void mousePressed(int x, int y) {
		if (menuButton.getRectangle().contains(x, y)){
			menuButton.setMousePressed(true);
        } else if (sauvegarderButton.getRectangle().contains(x,y)){
            sauvegarderButton.setMousePressed(true);
        }
        else if (startButton.getRectangle().contains(x,y)){
            startButton.setMousePressed(true);
        }
        else if (endButton.getRectangle().contains(x,y)){
            endButton.setMousePressed(true);
        }
        else {
            for (Button button : imageButton){
                if (button.getRectangle().contains(x,y)){
                    button.setMousePressed(true);
                    return;
                }
            }
        }

	}

	public void mouseReleased(int x, int y) {
		menuButton.resetBooleans();
        sauvegarderButton.resetBooleans();
        startButton.resetBooleans();
        endButton.resetBooleans();
        for (Button button : imageButton){
            button.resetBooleans();
        }
    }



    public BufferedImage getStartImg() {
        return this.imgStart;
    }

    public BufferedImage getEndImg () {
        return this.imgEnd;
    }




}
