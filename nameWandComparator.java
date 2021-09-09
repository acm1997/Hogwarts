import java.util.Comparator;
/**
 * Clase comparador de dos personajes por sus nombre de varita.
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class nameWandComparator implements Comparator<Character>
{
public int compare(Character c1, Character c2) {
        if(c1.getNameWand().compareTo(c2.getName()) == 0) 
            return 0;
        else if (c1.getNameWand().compareTo(c2.getNameWand()) > 0)
            return 1;
        else
            return -1;
    }
}
