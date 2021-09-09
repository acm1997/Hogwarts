import java.util.Comparator;
/**
 * Clase comparador de Varitas por el nombre.
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class nameComparator implements Comparator<Wand>
{
    public int compare(Wand w1, Wand w2) {
        if(w1.getName().compareTo(w2.getName()) == 0) 
            return 0;
        else if (w1.getName().compareTo(w2.getName()) > 0)
            return 1;
        else
            return -1;
    }
}
