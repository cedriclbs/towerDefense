import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.sql.Time;

public class GameScreen extends JPanel{
    private Random random;
    private BufferedImage image;
    private ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();


    public GameScreen(BufferedImage image){
        this.image = image;
        AfficheSprites();

        random = new Random();
    }
    
    private void AfficheSprites() {
        for(int y = 0; y < 10; y++){
            for(int x = 0; x < 10; x++){
                sprites.add(image.getSubimage(x*32, y*32, 32, 32));
                
            }
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //g.drawImage(sprites.get(19), 0, 0, null);
        //g.drawImage(img.getSubimage(32*9, 32, 32, 32), 0, 0,null);
       
       
       
        for(int x=0; x<20 ; x++){
            for(int y=0; y<20 ; y++){
                g.drawImage(sprites.get(getRndInt()), x*32, y*32, null);
            }
        }

    }

    

    private int getRndInt(){
        return random.nextInt(100);
    }
    
    private Color getRndColor(){
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }

}
