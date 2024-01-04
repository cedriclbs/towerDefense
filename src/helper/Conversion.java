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



}
