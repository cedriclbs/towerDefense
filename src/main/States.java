package main;

public enum States {
    
    JOUER, 
    MENU, 
    NIVEAU,
    EDITER;
    

    public static States states = MENU;

    public static void setStates (States state){
        states = state;
    }

}
