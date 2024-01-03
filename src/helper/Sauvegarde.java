package helper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Sauvegarde {

    public static BufferedImage getSpriteAtlas(){

        BufferedImage image = null;
		InputStream is = Sauvegarde.class.getClassLoader().getResourceAsStream("spriteatlas.png");
        
		try {
			image = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return image;
    }
    
	public static void CreationOfFile(){
		File txtFile = new File("txt/testTestFile.txt");
		
		try {
			txtFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void CreationNiveau(String name,int[] idA){
		File nouveauNiveau = new File("txt/"+name +".txt");
		if(nouveauNiveau.exists()){
			System.out.println("Fichier: "+ name +" existant !");
			return;
		}
		else {
			try {
				nouveauNiveau.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			UpdateFile(nouveauNiveau,idA);
		}
	}

	private static void UpdateFile(File file, int[] idA){
	
		try {
			PrintWriter write = new PrintWriter(file);
			for(Integer i: idA){
				write.println(i);
			}
			write.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
    
    public static void LectureFile(){
		File txtFile = new File("txt/Text.txt");
		
		try {
			Scanner scan = new Scanner(txtFile);
			while(scan.hasNextLine()){
				System.out.println(scan.nextLine());
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
