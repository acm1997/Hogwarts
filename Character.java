import java.util.ArrayList;
/**
 * Esta clase se encarga de guardar las características comunes de los 
 * personajes que existen.
 * 
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public abstract class Character {
    private String name;
    protected double energy; //Puntos de energía.
    protected double offensive; // Puntos ofensivos.
    protected double defensive; //Puntos defensivos.
    protected Wand wand;  
    protected ArrayList<ExtraPotion> ep = new ArrayList<ExtraPotion>();
    
   /**
     * Constructor por defecto de la clase Character.
     * @param name El nombre del personaje.
     * @param energy Puntos de energía o vida del personaje.
     * @param offensive Puntos ofensivos del personaje
     * @param defensive Puntos defensivos del personaje
     * @param wand Varita que posee el personaje
     * @param ep Lista de pociones que posee un personaje
     */
    public Character() {
        this.name = "";
        this.energy = 20;
        this.offensive = 20.0;
        this.defensive = 20.0;
        this.wand = null;
        this.ep = new ArrayList<ExtraPotion>();
    }
    /**
     * Constructor parametrizado de la clase Character
     * @param name El nombre del personaje.
     * @param energy Puntos de energía o vida del personaje.
     * @param offensive Puntos ofensivos del personaje
     * @param defensive Puntos defensivos del personaje
     * @param wand Varita que posee el personaje
     */
    public Character(String name, double offensive, double defensive, Wand w) {
        this.name = name;
        this.energy = 20.0;
        this.offensive = offensive;
        this.defensive = defensive;
        this.wand = w;
    }

   /**
     * @return name
     */
    public String getName() {
        return name;
    }
   /**
     * Metodo set para el nombre del personaje
     * @param name: El nombre del personaje
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo para calcular los puntos de energia del personaje
     * @return la energia del personaje
     */
    public double getEnergy() {
        return ((double)Math.round(this.energy*100d)/100d);
    }
    /**
     * Metodo set para los puntos de energia del personaje.
     * @param energy
     */
    public void setEnergy(double energy) {
        this.energy = energy;
    }
    /**
     * @return offensive
     */
    public double getOffensive() {
        return offensive;
    }

    /**
     * Metodo set para los puntos ofensivos.
     * @param offensive
     */
    public void setOffensive(double offensive) {
        this.offensive = offensive;
    }
    
    /**
     * @return defensive
     */
    public double getDefensive() {
        return defensive;
    }
    
    /**
     * Metodo set para los ountos defensivos.
     * @param defensive
     */
    public void setDefensive(double defensive) {
        this.defensive = defensive;
    }  
    
    /**
     * Metodo set para el nombre de la varita
     * @param wand
     */
    public void setWand(Wand w){
        this.wand = w;
    }
    
    /**
     * @return wand
     */
    public Wand getWand(){
        return this.wand;
    }
    
    /**
     * Metodo para obtener el nombre de la varita
     * @return el nombre de la varita
     */
    public String getNameWand(){
        return this.wand.getName();
    }
    
    /**
     * Metodo para obtener el nombre del tipo de varita.
     * @return nombre del tipo de varita
     */
    public String getNameClassWand(){
        return this.wand.getClass().getName();
    }
    
    /**
     * Asigna una poción a la lista de pociones del personaje actual. 
     * @Param p La poción a asignar
     */
    public void asignExtraPotion(ExtraPotion p){
        this.ep.add(p);
    }
    
    /**
     * Llama al método que usa la poción introducida por parámetros.
     * @param p La poción a usar
     */ 
    public void useExtraPotion(ExtraPotion p){
        p.use(this);
    }
    
    /**
     * Devuelve los attackPoint de la varita.
     * @return El resultado del calculo de sus puntos ofensivos
     */
    public double AttackPointsWand(){
        return ((double)Math.round(this.wand.attackPointsOffensive(this)*100d)/100d);
    }

    /**
     * Devuelve los resistancePoints de la varita.
     * @return El resultado del calculo de sus puntos defensivos
     */
    public double resistancePointsWand(){
        return ((double)Math.round(this.wand.resistancePointsDefensive(this)*100d)/100d);
    }
    
    /**
     * Metodo para atacar a otro personaje introduciendo sus parámetros.
     * @param oponent
     */
    public abstract void fight(Character oponent);
    
     /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public abstract boolean equals(Object obj);
    
    /*
    * (non-Javadoc)
    * @see java.lang.Object#toString()
    */
    public String toString(){
        return "character:<"+ this.name + ">" + " " + "<e: "+ this.getEnergy() + ">" + " " + "<o: "+ this.offensive + ">" + " " + "<d: "+ this.defensive + ">" + " " + this.wand.toString(); 
    }
    
}
