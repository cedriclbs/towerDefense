package scenes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import helper.Sauvegarde;


import java.awt.Component;

import interfaceUser.Button;
import main.Game;
import main.States;
import scenes.Jouer.Difficulty;

import static main.States.*;

public class Menu extends GameScene implements interfaceScenes {

    private Button jouerButton;
    private Button quitterButton;
    private Button niveauButton;
    private Button editButton;
    private Jouer jouer;


    
    public Menu(Game game,Jouer jouer) {

        super(game);
        this.jouer = jouer;
        int widthForText = 150;
		int x = 640 / 2 - widthForText / 2;
		int y = 260;
		int yOffset = 100;
		int heightForText = widthForText / 3;

        jouerButton = new Button("Jouer", x, y, widthForText, heightForText);
        editButton = new Button("Editer", x, y+yOffset,widthForText,heightForText); 
        niveauButton = new Button("Niveau",x, y + yOffset*2, widthForText, heightForText);
        quitterButton = new Button("Quitter",x, y + yOffset * 3, widthForText, heightForText);
    }

   

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Sauvegarde.getFond(), 0, 0,null);
        jouerButton.draw(graphics);
        editButton.draw(graphics);
        quitterButton.draw(graphics);
        niveauButton.draw(graphics);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if(jouerButton.getRectangle().contains(x,y)){
            setStates(JOUER);
        }
        else if(editButton.getRectangle().contains(x, y)){
            setStates(EDITER);
        }
        else if (quitterButton.getRectangle().contains(x,y)){
            System.exit(0);
        } 
        else if (niveauButton.getRectangle().contains(x,y)){
            openLevelSelectionDialog();
        }
    }

    private void openLevelSelectionDialog() {

        JDialog levelDialog = new JDialog();
        levelDialog.setTitle("Choisissez le Niveau");
        levelDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        levelDialog.setSize(400, 400);
        levelDialog.setLayout(new BoxLayout(levelDialog.getContentPane(), BoxLayout.Y_AXIS));
        levelDialog.setModal(true);
    
        JButton facileButton = createStyledButton("Niveau Facile",levelDialog);
        JButton moyenButton = createStyledButton("Niveau Moyen",levelDialog);
        JButton difficileButton = createStyledButton("Niveau Difficile",levelDialog);
        JButton marathonButton = createStyledButton("Marathon",levelDialog);
        

        levelDialog.add(Box.createVerticalStrut(20)); 
        levelDialog.add(facileButton);
        levelDialog.add(Box.createVerticalStrut(20));
        levelDialog.add(moyenButton);
        levelDialog.add(Box.createVerticalStrut(20));
        levelDialog.add(difficileButton);
        levelDialog.add(Box.createVerticalStrut(20)); 
        levelDialog.add(marathonButton);
        levelDialog.add(Box.createVerticalStrut(20)); 
    
        levelDialog.pack();
        levelDialog.setLocationRelativeTo(null);
        levelDialog.setVisible(true);
    }
    
    
    private JButton createStyledButton(String text,JDialog levelDialog) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(300, 100));
        button.setMaximumSize(new Dimension(250, 100)); 
    
       
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    
        
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentY(Component.CENTER_ALIGNMENT);
    
        button.addActionListener(e -> {
            switch (text) {
                case "Niveau Facile":
                    jouer.setDifficulty(Difficulty.FACILE);
                    jouer.reset(Difficulty.FACILE);
                    setStates(States.JOUER);
                    break;
                case "Niveau Moyen":
                    jouer.setDifficulty(Difficulty.MOYEN);
                    jouer.reset(Difficulty.MOYEN);
                    setStates(States.JOUER);

                    break;
                case "Niveau Difficile":
                    jouer.setDifficulty(Difficulty.DIFFICILE);
                    jouer.reset(Difficulty.DIFFICILE);
                    setStates(States.JOUER);
                    break;
                case "Marathon":
                    jouer.setDifficulty(Difficulty.MARATHON);
                    jouer.reset(Difficulty.MARATHON);
                    setStates(States.JOUER);
                    break;
                default:
                    System.out.println("Niveau non reconnu: " + text);
                    break;
            }
            jouer.updateWaveManagement();
            levelDialog.dispose(); // Ferme le dialogue après la sélection
        });
    
        return button;
    }
    
    
        
    @Override
    public void mouseMoved(int x, int y) {
        jouerButton.setMouseOnIt(false);
        quitterButton.setMouseOnIt(false);
        niveauButton.setMouseOnIt(false);

        if(jouerButton.getRectangle().contains(x,y)){
            jouerButton.setMouseOnIt(true);
        }
        else if(editButton.getRectangle().contains(x, y)){
            editButton.setMouseOnIt(true);
        }
        else if (quitterButton.getRectangle().contains(x,y)){
            quitterButton.setMouseOnIt(true);
        } 
        else if (niveauButton.getRectangle().contains(x,y)){
            niveauButton.setMouseOnIt(true);
        }
    }


    @Override
    public void mousePressed(int x, int y) {
        if(jouerButton.getRectangle().contains(x,y)){
            jouerButton.setMousePressed(true);
        }
        else if(editButton.getRectangle().contains(x, y)){
            editButton.setMousePressed(true);
        }
        else if(quitterButton.getRectangle().contains(x,y)){
            quitterButton.setMousePressed(true);
        }
        else if(niveauButton.getRectangle().contains(x,y)){
            niveauButton.setMousePressed(true);
        }      
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    @Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
	}    

    private void resetButtons() {
        jouerButton.resetBooleans();
        editButton.resetBooleans();
        quitterButton.resetBooleans();
        niveauButton.resetBooleans();

    }
    
}
