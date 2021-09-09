import java.util.Collections;
import java.util.ArrayList;
/**
 * Write a description of class orderNameWand here.
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class orderNameWand extends House
{

    /**
     * Constructor por defecto de orderOffensive
     */
    public orderNameWand()
    {
        super();
    }
    
    /**
     * Constructor parametrizado de orderOffensive 
     */
    public orderNameWand(String name)
    {
        super(name);
    }
    
    /**
     * Ordena los personajes de la casa con el comparador (de menos a más puntos ofensivo).
     */
    @Override
    public void orderCharacters(){    
        Collections.sort(this.characters, new nameWandComparator());
    }
}
