
/**
 * Se usa para potenciar los puntos ofensivos o defensivos.
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public abstract class ExtraPotion
{       
    /**
     * Constructor por defecto de la clase Potion
     */
    public ExtraPotion(){
        
    }
    /**
     * Clase que define un uso para la poción
     * @param c: Personaje al que se le aplicará los efectos de la poción 
     */
    public abstract void use(Character c);
    
}
