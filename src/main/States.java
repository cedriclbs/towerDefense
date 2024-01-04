package main;

public enum States {
    
    JOUER, 
    MENU, 
    PARAMETRES,
    EDITER;
    

    public static States states = MENU;

    public static void setStates (States state){
        states = state;
    }

}
