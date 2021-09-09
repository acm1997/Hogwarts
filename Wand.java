
/**
 * Varita que usará cada personaje para generar puntos de ataque y de resistencia.
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public abstract class Wand
{
    private String name;
    /**
     * Constructor por defecto de la clase "Wand".
     * @param name Nombre de la varita
     */
    public Wand()
    {
        this.name = "";
    }
    
    /**
     * Constructor parametrizado de la clase "Wand".
     * @param name Nombre de la varita
     */
    public Wand(String name){
        this.name = name;
    }
    
    /**
     * Metodo set del nombre de la varita
     * @param name Nombre de la varita
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * @return name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Metodo que devuelve los puntos tras atacar de manera ofensiva.
     * @param character: Personaje al que se le modificaran sus puntos ofensivos
     */
    public abstract double attackPointsOffensive(Character c);
    
    /**
     * Metodo que devuelve los puntos de resistencia tras haber el ataque.
     * @param character: Personaje al que se le modificaran sus puntos de resistencia o defensivos
     */
    public abstract double resistancePointsDefensive(Character c);
     
    /*
    * (non-Javadoc)
    * @see java.lang.Object#toString()
    */
    public String toString(){
        return "<wand: " + this.name + " (" + this.getClass().getName() + ")>";
    }
    

    

}
