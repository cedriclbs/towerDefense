package inputs;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;
import main.States;
import static main.States.*;


public class KeyboardListener implements KeyListener{

    private Game game;

    public KeyboardListener(Game game) {
        this.game = game;
    }


    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
    
        if (States.states == JOUER){
            game.getJouer().keyPressed(e);
        } 
        // else if (States.states == EDITER){
        //     game.getEdit().keyPressed(e);
        // }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
    
}
