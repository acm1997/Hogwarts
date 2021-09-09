
/**
 * Write a description of class FelixFelicisPotion here.
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class FelixFelicisPotion extends ExtraPotion
{

    /**
     * Constructor por defecto de la clase FelixFelicisPotion
     */
    public FelixFelicisPotion()
    {
    }
    
    /**
     * Incrementa los puntos ofensivos del personaje que pasas por parámetro.
     * @param c
     */
    @Override
    public void use(Character c){
        double offensive= c.getOffensive();
        c.setOffensive(offensive*1.3);
    }
    
}
