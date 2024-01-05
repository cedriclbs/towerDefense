package helper;

import object.Image;

public class Constante {
    
    public static class Heros{
        
        public static final int CANNON = 0;
        public static final int ARCHER = 1;
        public static final int MAGE = 2;
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
        public static final int ARAIGNEE = 0;
        public static final int COCHON = 1;
        public static final int MONSTREVERT = 2;
        public static final int RHINO = 3;

        public static float getVitesse(int TypeMonstre){
            switch(TypeMonstre){
                case ARAIGNEE://rhino
                return 0.3f;
                case COCHON://monstrevert
                return 0.45f;
                case MONSTREVERT://araigne
                return 0.55f;
                case RHINO: //cochon
                return 0.65f;
            }
            return 0;
        }
    }



    
}
