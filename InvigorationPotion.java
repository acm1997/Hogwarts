
/**
 * Write a description of class InvigorationPotion here.
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class InvigorationPotion extends ExtraPotion
{

    /**
     * Constructor por defecto de la clase InvigorationPotion
     */
    public InvigorationPotion()
    {
        
    }
    
    /**
     * Incrementa los puntos defensivos del personajes que pasas por parámetro.
     * @param c
     */
    @Override
    public void use(Character c){
        double defensive = c.getDefensive();
        double offensive = c.getOffensive();
        c.setDefensive(defensive*1.4);
        c.setOffensive(offensive*0.8);
    }
    
}
