package interfaceUser;

import java.util.ArrayList;
import java.awt.Color;
import object.Image;
import scenes.Edit;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import static main.States.*;

public class ToolBar  extends Bar{
    private Button menuButton, sauvegarderButton;
    private ArrayList<Button> imageButton = new ArrayList<> ();
    private Image choosedImage;
    private Edit edit;

    
    public ToolBar(int x, int y, int width, int height,Edit edit) {
        super(x, y, width, height);
        this.edit = edit;
        initializeButton();
    }

    private void initializeButton(){
        menuButton = new Button("Menu", 2, 642, 100, 30);
        sauvegarderButton = new Button("Sauvegarder", 2, 674, 100, 30);

        int w = 50;
        int h = 50;
        int xDepart =110;
        int yDepart = 650;
        int xoffset = (int)(w*1.1f);
        int i =0;

        for(Image image : edit.getGame().getImageManagement().Images){
            imageButton.add(new Button(image.getNom(), xDepart + xoffset*i, yDepart, w, h,i));
            i++;
        }
    }

    private void sauvegarderNiveau() {
        edit.sauvegarderNiveau();
    }

    public void affiche(Graphics graphics){
        graphics.setColor(new Color(220,123,15));
        graphics.fillRect(x, y, width, height);
        afficheButton(graphics);
    }

    private void afficheButton(Graphics graphics){
        menuButton.draw(graphics);
        sauvegarderButton.draw(graphics);
        afficheImageButton(graphics);
        afficheImageChoisies(graphics);
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

            if(button.getMouseOnIt()) {
                graphics.setColor(Color.BLUE);
            } else {
                graphics.setColor(Color.BLACK);
            }
            
            graphics.drawRect(button.x, button.y, button.width, button.height);

            if (button.getMousePressed()){
                graphics.drawRect(button.x+1, button.y+1, button.width-2, button.height-2);
                graphics.drawRect(button.x+2, button.y+2, button.width-4, button.height-4);
            }

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
        for (Button b : imageButton){
            b.setMouseOnIt(false);
        }


		if (menuButton.getRectangle().contains(x, y)){
			menuButton.setMouseOnIt(true);
        } 
        else if (sauvegarderButton.getRectangle().contains(x,y)){
            sauvegarderButton.setMouseOnIt(true);
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
        for (Button button : imageButton){
            button.resetBooleans();
        }
    }

}
