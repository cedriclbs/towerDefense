package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import inputs.KeyboardListener;
import inputs.MyMouseListener;
import scenes.Jouer;
import scenes.Menu;
import scenes.Parametres;

public class Game extends JFrame implements Runnable{
    private GameScreen gameScreen;
    private int Updates;
    private long LastTimeUPS;
    private Thread gameThread;
    private final double FPSGame = 120.0;
    private final double UPSGame = 60.0;

    private KeyboardListener clavier;
    private MyMouseListener souris;
    
    private Render render;
    
    private Jouer jouer;
    private Menu menu;
    private Parametres parametres;

    public Game(){
        
        
        //setSize(320*2, 320*2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        aideConstructeur();
        add(gameScreen);
        pack();
        setVisible(true);

    }


    public void aideConstructeur () {
        render = new Render(this);
        gameScreen = new GameScreen(this);
        jouer = new Jouer(this);
        menu = new Menu(this);
        parametres = new Parametres(this);
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
    

    private void start(){
        gameThread = new Thread(this){};
        gameThread.start();
    }


    private void inputsStart () {
        souris=new MyMouseListener();
        addMouseListener(souris);
        addMouseMotionListener(souris);
        clavier=new KeyboardListener();
        addKeyListener(clavier);
        requestFocus();
    }


    public static void main(String[] args){
        
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
            game.inputsStart();
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
