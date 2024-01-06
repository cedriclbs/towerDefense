package interfaceUser;

import java.awt.Color;
import java.awt.Graphics;

public class Bar {
    protected int x,y,width,height;

    public Bar(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    protected void afficheButton (Graphics graphics, Button button){
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
