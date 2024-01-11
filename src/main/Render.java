package main;

import java.awt.Graphics;


public class Render {
    
    private Game game;


    public Render (Game game){
        this.game = game;

    }


    public void render (Graphics graphics){
        switch (States.states){
            case JOUER:
                game.getJouer().render(graphics);
            break;

            case MENU:
                game.getMenu().render(graphics);
            break;

            case NIVEAU:
                game.getParametres().render(graphics);
            break;
            
            case EDITER:
                game.getEdit().render(graphics);
                break;
            default:
                break;
        }
    }

}
