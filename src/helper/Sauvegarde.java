package helper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import object.Point;

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
		File txtFile = new File("ressources/txt" + File.separator + "testTestFile.txt");
		
		try {
			txtFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void CreationNiveau(String nom,int[] idA){
		File directory = new File("ressources/txt");
		if (!directory.exists()) {
			directory.mkdirs();
		}
		File nouveauNiveau = new File(directory, nom + ".txt");
		if(nouveauNiveau.exists()){
			System.out.println("Fichier: "+ nom +" existant !");
			return;
		}
		else {
			try {
				nouveauNiveau.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			UpdateFile(nouveauNiveau,idA, new Point(0,0), new Point(0,0));
		}
	}



	public static ArrayList<Point> getNiveauPoint (String nom){
		File niveauFile = new File ("ressources/txt/"+nom+".txt");

		if (niveauFile.exists()){
			ArrayList<Integer> liste = LectureFile(niveauFile);
			ArrayList<Point> nivpoints = new ArrayList<>();
			nivpoints.add(new Point(liste.get(400), liste.get(401)));
			nivpoints.add(new Point(liste.get(402), liste.get(403)));
			return nivpoints;
		} else {
			System.out.println("Fichier :" + nom + " n'existe pas.");
			return null;
		}
	}



	private static void UpdateFile(File file, int[] idA, Point start, Point end){
	
		try {
			PrintWriter write = new PrintWriter(file);
			for(Integer i: idA){
				write.println(i);
			}
			write.println(start.getxPoint());
			write.println(start.getyPoint());
			write.println(end.getxPoint());
			write.println(end.getyPoint());
			
			write.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
    
    private static ArrayList<Integer> LectureFile(File file){
		ArrayList<Integer> liste = new ArrayList<>();
		
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()){
				liste.add(Integer.parseInt(scan.nextLine()));
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return liste;
	}


	public static int[][] getNiveau (String nom){
		File niveauFile = new File ("ressources/txt/"+nom+".txt");

		if (niveauFile.exists()){
			ArrayList<Integer> liste = LectureFile(niveauFile);
			return Conversion.convertir(liste, 20, 20);
		} else {
			System.out.println("Fichier :" + nom + " n'existe pas.");
			return null;
		}

	}


	public static void SauvNiveau (String nom, int [][]tab, Point start, Point end){
		File niveau = new File("ressources/txt/"+nom +".txt");

		if (niveau.exists()){
			UpdateFile(niveau, Conversion.convertir2en1(tab), start, end);
		} else {
			System.out.println("fichier non existant");
			return;
		}


	}


}
