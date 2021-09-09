
/**
 * Varita orientada al ataque.
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class OffensiveHawthorn extends Wand
{

    /**
     * Constructor por defecto de la clase OffensiveHawthorn
     */
    public OffensiveHawthorn()
    {
        super();
    }
    
    /**
     * Constructor parametrizado de la clase OffensiveHawthorn
     */
    public OffensiveHawthorn(String name){
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
        result = (0.6*c.getEnergy() + 1.4*c.getOffensive());
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
        result = (0.8*c.getEnergy() + 0.2*c.getDefensive());
        return result;
    } 
    

    
   
    
   
}
