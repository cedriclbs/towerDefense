package Monster;
import static helper.Constante.Monstres.ARAIGNEE;

import management.MonsterManagement;
public class Araignee extends Monstres {

    public Araignee(float x, float y, int id,MonsterManagement monsterManagement) {
        super(x, y, id, ARAIGNEE,monsterManagement);
        sante = 20;
    }
    
}
