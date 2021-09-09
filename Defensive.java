/**
 * Describe la clase de Personaje de tipo defensivo
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class Defensive extends Character {
    
    /**
     * Constructor por defecto de Defensive
     */
    public Defensive(){
        super();
        this.setDefensive(this.getDefensive()+5);
    }
    
    /**
     * Constructor parametrizado de Defensive
     */
    public Defensive(String name ,double offensive, double defensive, Wand w) {
        super(name, offensive, defensive+5.0, w);
           
    }
    
    /**
     * Metodo mediante el cual el personaje lucha contra su oponente que introduzco por parámetros.
     * @param oponent
     */
    @Override
    public void fight(Character oponent){
        if(this.AttackPointsWand() > oponent.resistancePointsWand()){
            double energy = oponent.getEnergy() - (this.AttackPointsWand() - oponent.resistancePointsWand());
            if(energy < 0){
                oponent.setEnergy(0);
            }else oponent.setEnergy(energy);       
        }
    }
    
     /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Character)){
            return false;
        }
        Character c = (Character) obj;
        return this.getName().equals(c.getName());
    }
    
}