package inputs;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.States;
import static main.States.*;


public class KeyboardListener implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
    
        if (e.getKeyCode() == KeyEvent.VK_A){
            States.states=MENU;
        } else if (e.getKeyCode() == KeyEvent.VK_S){
            States.states=JOUER;
        } else if (e.getKeyCode() == KeyEvent.VK_D){
            States.states=PARAMETRES;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
    
}
