package Monster;

import static helper.Constante.Monstres.MONSTREVERT;

import management.MonsterManagement;

public class MonstreVert extends Monstres {

    public MonstreVert(float x, float y, int id,MonsterManagement monsterManagement) {
        super(x, y, id, MONSTREVERT,monsterManagement);
        sante = 80;
    }

    
}