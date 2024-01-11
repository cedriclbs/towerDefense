package inputs;

import java.awt.event.MouseMotionListener;

import main.Game;
import main.States;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseMotionListener, MouseListener {


    private Game game;

    public MyMouseListener (Game game){
        this.game=game;
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

        if (e.getButton()==MouseEvent.BUTTON1){
            switch(States.states){
                case JOUER:
                    game.getJouer().mouseClicked(e.getX(), e.getY());
                    break;
                case MENU:
                    game.getMenu().mouseClicked(e.getX(),e.getY());
                    break;
                case NIVEAU:
                    game.getParametres().mouseClicked(e.getX(),e.getY());
                    break;
                case EDITER: 
                    game.getEdit().mouseClicked(e.getX(),e.getY());
                    break;
                case GAMEOVER: 
                    game.getGameOver().mouseClicked(e.getX(),e.getY());
                    break;
                default:
                    break;
                
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch(States.states){
            case JOUER:
                game.getJouer().mousePressed(e.getX(), e.getY());
                break;
            case MENU:
                game.getMenu().mousePressed(e.getX(),e.getY());
                break;
            case NIVEAU:
                game.getParametres().mousePressed(e.getX(), e.getY());
                break;
            case EDITER: 
                game.getEdit().mousePressed(e.getX(),e.getY());
                break;
            case GAMEOVER: 
                game.getGameOver().mousePressed(e.getX(),e.getY());
                break;
            default:
                break;
            
        }
    }    

    @Override
    public void mouseReleased(MouseEvent e) {
        switch(States.states){
            case JOUER:
                game.getJouer().mouseReleased(e.getX(),e.getY());
                break;
            case MENU:
                game.getMenu().mouseReleased(e.getX(),e.getY());
                break;
            case NIVEAU:
                game.getParametres().mouseReleased(e.getX(),e.getY());
                break;
            case EDITER: 
                game.getEdit().mouseReleased(e.getX(),e.getY());
                break;
            case GAMEOVER: 
                game.getGameOver().mouseReleased(e.getX(),e.getY());
                break;
            default:
                break;
            
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch(States.states){
            case JOUER:
                game.getJouer().mouseDragged(e.getX(),e.getY());
                break;
            case MENU:
                game.getMenu().mouseDragged(e.getX(),e.getY());
                break;
            case NIVEAU:
                game.getParametres().mouseDragged(e.getX(),e.getY());
                break;
            case EDITER: 
                game.getEdit().mouseDragged(e.getX(),e.getY());
                break;
            case GAMEOVER: 
                game.getGameOver().mouseDragged(e.getX(),e.getY());
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        switch(States.states){
            case JOUER:
                game.getJouer().mouseMoved(e.getX(),e.getY());
                break;
            case MENU:
                game.getMenu().mouseMoved(e.getX(),e.getY());
                break;
            case NIVEAU:
                game.getParametres().mouseMoved(e.getX(),e.getY());
                break;
            case EDITER: 
                game.getEdit().mouseMoved(e.getX(),e.getY());
                break;
            case GAMEOVER: 
                game.getGameOver().mouseMoved(e.getX(),e.getY());
                break;
            default:
                break;
        }
        
    }

    
}