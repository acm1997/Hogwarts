import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Cada una de las casas que competirá en los duelos.
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public abstract class House
{
    String name;
    protected ArrayList <Character> characters; //Guarda los personajes distintos de cada casa.
    
   /**
     * Constructor por defecto de la clase House.
     * @param name El nombre de la casa.
     * @param characters Lista donde se almacenarán los distintos personajes que pertenezcan a la casa correspondiente.
     */
    public House()
    {
        this.name = "";
        characters = new ArrayList<Character>();
    }
    
    /**
     * Constructor parametrizado por nombre de la clase House.
     * @param characters Lista donde se almacenarán los distintos personajes que pertenezcan a la casa correspondiente.
     * @param name El nombre de la casa.
     */
    public House(String name)
    {
        characters = new ArrayList<Character>();
        this.name = name;
    }
    
    /**
     * @return name
     */
    public String getName(){
        return name;
    }
    
   /**
     * Metodo set para el nombre a la casa
     * @param name: El nombre de la casa
     */
    public void setName(String name){
        this.name = name;
    }
    
   /*
    * (non-Javadoc)
    * @see java.lang.Object#toString()
    */
    public String toString(){
        return "house:<"+ this.name + ">";
    }
   /**
     * Método que inserta un personaje en la lista de personajes de la casa
     * @param Characters El personaje a insertar.
     */
    public void addMember(Character c){
        this.characters.add(c);
    }
   /**
     * Método abstracto que ordenará sus personajes siguiendo distinto criterio según la casa.
     */
    public abstract void orderCharacters();
   
   /**
     * @return characters
     */
    public ArrayList<Character> getCharacters(){
        return this.characters; 
    }
    /**
     * Método que cuenta la energía de todos los personajes de la casa.
     * @return total
     */
    public double getCountEnergy(){
    double total=0.0;
    for(Character c : this.characters){
        total = total + c.getEnergy();
    }
        return total;
    }
    
    /**
     * Método que cuenta la suma de los puntos ofensivos y defensivos de todos los personajes de la casa.
     * @return total
     */    
    public double getCountOffensiveDefensive(){
            double total=0.0;
        for(Character c : this.characters){
            total = total + (c.getDefensive() + c.getOffensive());
        }
            return total;
    }
    
    /**
     * Obtener el primer personaje de la lista de personajes de la casa actual.
     * @return Character
     */
    public Character getFirstCharacter(){
        Character aux = this.characters.get(0);
        return aux;       
    }
    
}
