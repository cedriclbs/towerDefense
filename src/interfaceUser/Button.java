package interfaceUser;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Button {
    
    String buttonName;
    public int x;
    public int y;
    public int width;
    public int height;
    public int id;
    private Rectangle rectangle;
    private boolean mouseOnIt;
    private boolean mousePressed;
    

    public Button (String buttonName, int x, int y, int width, int height) {
        this.buttonName = buttonName;
        this.x =x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.rectangle = new Rectangle(x,y,width,height);
        this.id = -4;
    }

    public Button (String buttonName, int x, int y, int width, int height,int id) {
        this.buttonName = buttonName;
        this.x =x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.id = id;
        this.rectangle = new Rectangle(x,y,width,height);
    }

    public Rectangle getRectangle () {
        return rectangle;
    }

    public void draw (Graphics graphics){
        if (mouseOnIt){
            graphics.setColor(Color.gray);
        } else {
        graphics.setColor(Color.WHITE);
        }
        graphics.fillRect(x,y,width,height);


        graphics.setColor(Color.black);
		graphics.drawRect(x, y, width, height);
		if (mousePressed) {
			graphics.drawRect(x + 1, y + 1, width - 2, height - 2);
			graphics.drawRect(x + 2, y + 2, width - 4, height - 4);
		}
       
       

        int widthText = graphics.getFontMetrics().stringWidth(buttonName);
        int heightText = graphics.getFontMetrics().getHeight();
        graphics.drawString(buttonName, x - widthText/2 + width/2, heightText/2 + height/2 + y);

    }

    
    public void setMouseOnIt (boolean b){
        this.mouseOnIt = b;
    }

    public void setMousePressed (boolean b){
        this.mousePressed = b;
    }

    public void resetBooleans () {
        this.mouseOnIt = false;
        this.mousePressed = false;
    }

    public int getId(){
        return id;
    }


}
