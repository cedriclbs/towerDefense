import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Game extends JFrame implements Runnable{
    private GameScreen gameScreen;
    private BufferedImage image; 
    private int Updates;
    private long LastTimeUPS;
    private Thread gameThread;
    private final double FPSGame = 120.0;
    private final double UPSGame = 60.0;

    public Game(){
        
        importImg();
        
        setSize(640, 640);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        gameScreen = new GameScreen(image);
        add(gameScreen);
    }

    private void importImg() {

		InputStream is = getClass().getResourceAsStream("/spriteatlas.png");

		try {
			image = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void start(){
        gameThread = new Thread(this){};
        gameThread.start();
    }


    public static void main(String[] args){
        
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
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
