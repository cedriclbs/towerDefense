package Monster;
import static helper.Constante.Monstres.ARAIGNEE;
public class Araignee extends Monstres {

    public Araignee(float x, float y, int id) {
        super(x, y, id, ARAIGNEE);
        sante = 20;
    }
    
}
