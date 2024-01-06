package Monster;

import static helper.Constante.Monstres.MONSTREVERT;

public class MonstreVert extends Monstres {

    public MonstreVert(float x, float y, int id) {
        super(x, y, id, MONSTREVERT);
        setDefaultHealth();
    }

    
}