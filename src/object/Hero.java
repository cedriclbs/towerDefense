package object;

public class Hero {
    private int x,y,id,herotype;
    private float degats, portee, tpsEcoulement;


    public Hero(int x, int y, int id, int herotype) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.herotype = herotype;
        setDefaultDegats();
        setDefaultPortee();
        setDefaultTpsEcoulement();
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

    public float getDegats() {
        return degats;
    }

    public void setDegats(float degats) {
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
