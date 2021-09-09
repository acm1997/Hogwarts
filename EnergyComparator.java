import java.util.Comparator;
/**
 * Clase comparador de dos personajes por sus puntos de energía.
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class EnergyComparator implements Comparator<Character>
{
    public int compare(Character c1, Character c2) {
        int i=0;
        if(c1.getEnergy() == c2.getEnergy()) {
            return c1.getName().compareTo(c2.getName());
        }
        else {
             if (c1.getEnergy() > c2.getEnergy())
                i=1;
             else
                i=-1;
        }
        return i;
    }
}
