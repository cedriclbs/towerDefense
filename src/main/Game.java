package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import helper.Sauvegarde;
import management.ImageManagement;
import scenes.Edit;
import scenes.Jouer;
import scenes.Menu;
import scenes.Parametres;

public class Game extends JFrame implements Runnable{
    private GameScreen gameScreen;
    private Thread gameThread;
    private final double FPSGame = 120.0;
    private final double UPSGame = 60.0;


    
    private Render render;
    
    private Jouer jouer;
    private Menu menu;
    private Parametres parametres;
    private Edit edit;
    private ImageManagement imageManagement;

    public Game(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        aideConstructeur();
        creationNivParDefault();
        add(gameScreen);
        pack();
        setVisible(true);

    }

    private void creationNivParDefault() {
        int[] arr = new int[400];
        for(int i=0; i<arr.length; i++){
            arr[i] = 0;
        }

        Sauvegarde.CreationNiveau("Nouveau_niveau", arr);
    }

    public void aideConstructeur () {
        imageManagement = new ImageManagement();
        render = new Render(this);
        gameScreen = new GameScreen(this);
        jouer = new Jouer(this);
        menu = new Menu(this);
        parametres = new Parametres(this);
        edit = new Edit(this);
        
    }

    public Render getRender () {
        return this.render;
    }
    public Jouer getJouer () {
        return this.jouer;
    }
    public Menu getMenu () {
        return this.menu;
    }
    public Parametres getParametres () {
        return this.parametres;
    }
    public Edit getEdit(){
        return edit;
    }
    public ImageManagement getImageManagement(){
        return imageManagement;
    }
    

    private void start(){
        gameThread = new Thread(this){};
        gameThread.start();
    }


    

    public static void main(String[] args){
        
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
            game.gameScreen.inputsStart();
            game.start();
        });
    }

    @Override
    public void run() {
        
        double TimeUpdate = 1000000000.0 / UPSGame;
        double TimeFPS = 1000000000.0 / FPSGame;
        
        long LastFPS=System.nanoTime();
        long LastUpdate = System.nanoTime();
        long LastTimeVerif = System.currentTimeMillis();
       
        int FPS =0;
        int Updates = 0;

        long current;
        
        while(true){
            current = System.nanoTime();
            if(current - LastFPS >= TimeFPS){
                repaint();
                LastFPS = current;
                FPS++;
            }
            if(current - LastUpdate >= TimeUpdate){
                LastUpdate = current;
                Updates++;
            }
            if(System.currentTimeMillis()-LastTimeVerif >= 1000){
                System.out.println("FPS : " + FPS + " | UPS : " + Updates);
                FPS = 0;
                Updates =0;
                LastTimeVerif = System.currentTimeMillis();
            }
        }
    }
}
