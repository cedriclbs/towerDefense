package main;

public enum States {
    
    JOUER, 
    MENU, 
    NIVEAU,
    EDITER,
    GAMEOVER;
    

    public static States states = MENU;

    public static void setStates (States state){
        states = state;
    }

}
