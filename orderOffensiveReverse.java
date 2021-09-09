import java.util.Collections;
import java.util.ArrayList;
/**
 * Write a description of class orderOffensiveReverse here.
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class orderOffensiveReverse extends House
{
    /**
     *  Constructor por defecto de orderOffensiveReverse
     */
    public orderOffensiveReverse()
    {
        super();
    }
    
    /**
     * Constructor parametrizado de orderOffensiveReverse
     */
    public orderOffensiveReverse(String name)
    {
        super(name);
    }
    
    /**
     * Ordena los personajes de la casa con el comparador (de más a menos puntos ofensivos)
     */
    @Override
    public void orderCharacters(){    
        Collections.sort(this.characters, new OffensiveComparator());
        Collections.reverse(this.characters);
    }

}
