package helper;

public class Constante {


    public static class Missiles{
        public static final int FLECHE = 0;
        public static final int BOMBE = 2;
        public static final int GIVRE = 1;

        public static float getVitesse(int type){
            switch(type){
                case FLECHE:
                    return 3f;
                case BOMBE:
                    return 1f;
                case GIVRE:
                    return 2f;
            }
            return 0f;
        }
        
    }
    
    public static class Heros{
        
        public static final int CANNON = 0;
        public static final int ARCHER = 1;
        public static final int MAGE = 2;
        
        public static int getHeroPrix(int typeHeros){
            switch(typeHeros){
                case CANNON:
                return 65;
                case ARCHER:
                return 30;
                case MAGE:
                return 45;
            }
            return 0;
        }
        
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

        public static int getDefaultDegats (int typeHeros){
            switch(typeHeros){
                case CANNON:
                return 10;
                case ARCHER:
                return 3;
                case MAGE:
                return 5;
            }
            return 0;
        }

        public static float getDefaultPortee (int typeHeros){
            switch(typeHeros){
                case CANNON:
                return 70;
                case ARCHER:
                return 100;
                case MAGE:
                return 80;
            }
            return 0;
        }

        public static float getDefaultTpsEcoulement (int typeHeros){
            switch(typeHeros){
                case CANNON:
                return 120;
                case ARCHER:
                return 25;
                case MAGE:
                return 40;
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

        public static final int MONSTREVERT = 0; //rhino
        public static final int RHINO = 1; // monstrevert
        public static final int COCHON = 2; // araignée 
        public static final int ARAIGNEE = 3; //cochon
        

        public static int getOrMonstres(int TypeMonstre) {
            switch(TypeMonstre){
                case ARAIGNEE://cochon
                return 5;
                case COCHON://araignée
                return 3;
                case MONSTREVERT://Rhino
                return 20;
                case RHINO: //Monstre vert
                return 10;
            }
            return 0;
        }

        public static float getVitesse(int TypeMonstre){
            switch(TypeMonstre){
                case ARAIGNEE://cochon
                return 0.70f;
                case COCHON://araignée
                return 0.50f;
                case MONSTREVERT://Rhino
                return 0.40f;
                case RHINO: //Monstre vert
                return 0.35f;
            }
            return 0;
        }

        public static int getDefaultHealth(int typedemonstre) {
            switch(typedemonstre){
                case ARAIGNEE:
                return 60;
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
