package helper;

import object.Image;

public class Constante {
    
    public static class Heros{
        
        public static final int CANNON = 0;
        public static final int ARCHER = 1;
        public static final int MAGE = 2;
        
        public static String getNom(int typeHeros){
            switch(typeHeros){
                case CANNON:
                return "Cannon";
                case ARCHER:
                return "Archer";
                case MAGE:
                return "Mage";
            }
            return "";
        }

        public static float getDefaultDegats (int typeHeros){
            switch(typeHeros){
                case CANNON:
                return 30;
                case ARCHER:
                return 20;
                case MAGE:
                return 10;
            }
            return 0;
        }

        public static float getDefaultPortee (int typeHeros){
            switch(typeHeros){
                case CANNON:
                return 100;
                case ARCHER:
                return 100;
                case MAGE:
                return 100;
            }
            return 0;
        }

        public static float getDefaultTpsEcoulement (int typeHeros){
            switch(typeHeros){
                case CANNON:
                return 10;
                case ARCHER:
                return 10;
                case MAGE:
                return 10;
            }
            return 0;
        }
    }

    public static class Direction {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class Images{
        public static final int EAU_IMAGE = 0;
        public static final int HERBE_IMAGE = 1;
        public static final int ROUTE_IMAGE = 2;
    }


    public static class Monstres {

        public static final int MONSTREVERT = 0;
        public static final int RHINO = 1;
        public static final int COCHON = 2;
        public static final int ARAIGNEE = 3;
        

        public static float getVitesse(int TypeMonstre){
            switch(TypeMonstre){
                case ARAIGNEE://rhino
                return 0.65f;
                case COCHON://monstrevert
                return 0.55f;
                case MONSTREVERT://araigne
                return 0.45f;
                case RHINO: //cochon
                return 0.3f;
            }
            return 0;
        }

        public static int getDefaultHealth(int typedemonstre) {
            switch(typedemonstre){
                case ARAIGNEE:
                return 20;
                case COCHON:
                return 50;
                case MONSTREVERT:
                return 80;
                case RHINO: 
                return 100;
            }
            return 0;
        }
    }
}
