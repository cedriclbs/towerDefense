package object;



public class Hero {
    private int x;
    private int y;
    private int id;
    private int herotype;

    public Hero(int x, int y, int id, int herotype) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.herotype = herotype;
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
}
