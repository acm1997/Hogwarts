import java.util.Comparator;
/**
 * Clase comparador de dos personajes por sus puntos defensivos.
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class DefensiveComparator implements Comparator<Character>
{
    public int compare(Character c1, Character c2) {
            int i=0;
            if(c1.getDefensive() == c2.getDefensive()) {
                if(c1.getName().compareTo(c2.getName()) < 0)
                    i=-1;       
                if(c1.getName().compareTo(c2.getName()) > 0)
                    i=1;
            }
            else {
                 if (c1.getDefensive() > c2.getDefensive())
                    i=1;
                 else
                    i=-1;
            }
            return i;
        }
}
