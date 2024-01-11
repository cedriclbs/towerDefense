package Monster;

import static helper.Constante.Monstres.COCHON;

import management.MonsterManagement;;

public class Cochon extends Monstres {

    public Cochon(float x, float y, int id,MonsterManagement monsterManagement) {
        super(x, y, id, COCHON, monsterManagement);
        sante = 50;
    }

    
}