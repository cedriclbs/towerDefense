package Monster;
import static helper.Constante.Monstres.RHINO;

import management.MonsterManagement;

public class Rhino extends Monstres {

    public Rhino(float x, float y, int id,MonsterManagement monsterManagement) {
        super(x, y, id, RHINO, monsterManagement);
        sante = 100;
    }
    
}
