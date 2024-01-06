package helper;

import java.util.ArrayList;

public class Conversion {
    

    public static int [][] convertir (ArrayList<Integer> liste, int x, int y){
        int [][] tab = new int [x][y];

        for (int i = 0 ; i < tab.length ; i++){
            for (int j = 0 ; j < tab[i].length ; j++){
                int temp = i*y+j;
                tab[i][j] = liste.get(temp);
            }
        }
        return tab;
    }


    public static int [] convertir2en1 (int [][]tab){
        int []res = new int [tab.length * tab[0].length] ;

        for (int i = 0 ; i < tab.length ; i++){
            for (int j = 0 ; j < tab[i].length ; j++){
                int temp = i*tab.length+j;
                res[temp] = tab[i][j];
            }
        }
        return res;
    }

    public static int getHypDistance(float x1, float y1, float x2, float y2){ //calcul l'hypo entre le h et le m pour voir si le m est à portée du h
        float diffx = Math.abs(x1-x2);
        float diffy = Math.abs(y1-y2);

        return (int) Math.hypot(diffx, diffy);
    }

}
