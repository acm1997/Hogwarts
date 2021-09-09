import java.util.Collections;
import java.util.ArrayList;
/**
 * Write a description of class orderDefensive here.
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class orderDefensive extends House
{   
    
    /**
     * Constructor parametrizado de orderDefensive
     */
    public orderDefensive(String name)
    {
        super(name);
    }
    
   /**
     * Constructor por defecto de orderDefensive
     */
    public orderDefensive(){
      super();   
    }
    
    /**
     * Ordena los personajes de la casa con el comparador (de menos a más puntos defensivos)
     */
    @Override
    public void orderCharacters(){    
        //ArrayList<Character> listaOrdenada = new ArrayList<Character>(this.characters);
        Collections.sort(this.characters, new DefensiveComparator());
    }

}
