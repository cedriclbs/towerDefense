package Monster;

import static helper.Constante.Monstres.COCHON;;

public class Cochon extends Monstres {

    public Cochon(float x, float y, int id) {
        super(x, y, id, COCHON);
        sante = 50;
    }

    
}