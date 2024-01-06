package object;

public class Hero {
    private int x,y,id,herotype, RecharcheT,degats;
    private float portee, tpsEcoulement;


    public Hero(int x, int y, int id, int herotype) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.herotype = herotype;
        setDefaultDegats();
        setDefaultPortee();
        setDefaultTpsEcoulement();
    }

    public void update(){
        RecharcheT++;
    }

    public boolean EstFinRecharge() {
        return RecharcheT >= tpsEcoulement;
    }

    public void resetRecharge() {
        RecharcheT = 0;
    }
    
    private void setDefaultDegats() {
        this.degats = helper.Constante.Heros.getDefaultDegats(herotype);
    }

    private void setDefaultPortee() {
        this.portee = helper.Constante.Heros.getDefaultPortee(herotype);

    }

    private void setDefaultTpsEcoulement() {
        this.tpsEcoulement = helper.Constante.Heros.getDefaultTpsEcoulement(herotype);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }

    public int getHeroType(){
        return herotype;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public float getPortee() {
        return portee;
    }

    public void setPortee(float portee) {
        this.portee = portee;
    }

    public float getTpsEcoulement() {
        return tpsEcoulement;
    }

    public void setTpsEcoulement(float tpsEcoulement) {
        this.tpsEcoulement = tpsEcoulement;
    }
    
}
