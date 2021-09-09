
/**
 * Varita orientada a la defensa
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class HollyDefensive extends Wand
{   
    /**
     * Constructor por defecto de la clase HollyDefensive
     */
    public HollyDefensive(){
        super();
    }
    
    /**
     * Constructor parametrizado de la clase HollyDefensive
     */
    public HollyDefensive(String name){
        super(name);
    }
    
    /**
     * Metodo que devuelve los puntos tras atacar de manera ofensiva.
     * @param character: Personaje al que se le modificaran sus puntos ofensivos
     * @return result
     */
    @Override
    public double attackPointsOffensive(Character c){
        double result=0.0;
        result = (0.7*c.getEnergy() + 0.3*c.getOffensive());
        return result;
    }   
    
    /**
     * Metodo que devuelve los puntos de resistencia tras haber el ataque.
     * @param character: Personaje al que se le modificaran sus puntos de resistencia o defensivos
     * @return result
     */ 
    @Override
    public double resistancePointsDefensive(Character c){
        double result=0.0;
        result = (0.9*c.getEnergy() + 1.1*c.getDefensive());
        return result;
    } 
    
}
