 import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase "Hogwarts" que se encarga de ejecutar los procesos principales.
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class Hogwarts
{
    private HashMap <String, House> housesMap;
    private ArrayList <Character> charactersDuel;
    private ArrayList <Wand> wands;//Coleccion de varitas a usar por los personajes en los duelos.
    private ArrayList <Character> dungeon; //Calabozo donde se meten personajes sin energía.
    private static Hogwarts hw = null;
    
    /**
     * Constructor por defecto de la clase Hogwarts
     */
    public Hogwarts()
    {
        housesMap = new  HashMap <String, House>();
        charactersDuel = new ArrayList <Character> ();
        wands = new ArrayList <Wand>();
        dungeon = new ArrayList<Character>();
    }
    
    /** 
     * Method for use the singleton pattern
     * @return: The StockManager instance
     */
    public static Hogwarts getInstance() {
        if(hw == null)
            hw = new Hogwarts();
        return hw;
    }
    
    /**
     * Añadir casa al castillo
     * @param House
     */
    public void putHouse(House h){
        this.housesMap.put(h.getName(), h);
    }      
    
    /**
     * Inserta en la lista de personajes de duelo al primer personaje de cada casa.
     */
    public void solicitCharacters(){
        for(House hAux : this.housesMap.values()){
            if(!hAux.getCharacters().isEmpty()){
                hAux.addMember(hAux.getFirstCharacter());//Le inserto al final.
                this.charactersDuel.add(hAux.getFirstCharacter());
                hAux.getCharacters().remove(0);
            }
        } 
    }
    
    /**
     * Inserta en la lista calabozo los personajes sin energia
     * @param ch: Personaje a insertar en la lista del calabozo
     */
    public void addDungeon(Character ch){
        dungeon.add(ch);
    }
    
    /**
     * Devuelve una lista con todos los personajes elegidos de entre
     * todas las casas ordenados ascendentemente por energía.
     * @return listaOrdenada
     */
    public ArrayList<Character> orderCharactersByEnergy(){
        ArrayList<Character> listaOrdenada = new ArrayList<Character>(this.charactersDuel);
        Collections.sort(listaOrdenada, new EnergyComparator());
        return listaOrdenada;
    } 
    
    /**
     * Añade una nueva varita a la lista de varitas.
     * @param w: Varita que se va a añadir
     */
    public void newWand(Wand w){
        this.wands.add(w);
    }
    
    /**
     * Asigna una nueva varita a un personaje y la elimina de la lista de varitas.
     * @param c
     */
    public void asignNewWand(Character c){
        Wand wAux = wands.get(0);
        c.setWand(wAux);
        //wands.add(wAux);
        wands.remove(0);
    }
    
    /**
     * Método que ordena la lista de varitas según el comparador utilizado.
     */
    public void orderWands(){
         Collections.sort(this.wands, new nameComparator());
    }
    
    /**
     * Método para indicar la casa ganadora tras los duelos.
     * @return hWin
     */
    public House winnerHouseBySize(){
        House hWin = null;
        int totalCharacters = 0;
        double totalEnergy = 0.0;
        double totalDefensiveOffensive = 1000000.0;
        
        for(House h : this.housesMap.values()){
            if(housesMap.get(h.getName()).getCharacters().size() > totalCharacters){
                hWin = h;
                totalCharacters = h.getCharacters().size();
            }
            else {
                if(housesMap.get(h.getName()).getCharacters().size() != 0){
                  if(housesMap.get(h.getName()).getCharacters().size() == totalCharacters){
                    if(housesMap.get(h.getName()).getCountEnergy() > totalEnergy){
                        hWin = h;
                        totalEnergy = housesMap.get(h).getCountEnergy();
                    }
                    else{
                        if(housesMap.get(h.getName()).getCountOffensiveDefensive() < totalDefensiveOffensive){
                            hWin = h;
                            totalDefensiveOffensive = housesMap.get(h).getCountOffensiveDefensive();
                        }   
                    }
                  }
                }
            }          
        }       
        return hWin;
    }
    
    /**
     * Metodo que escribe en el fichero de salida los personajes que queden en las diferentes casas
     * @param bw: Flujo de salida del fichero
     * @param houseMap: Hashmap que guarda las casas del castillo
     */
    public void showCharactersHouses (BufferedWriter bw,HashMap <String, House> housesMap) throws IOException{
        //Mostramos los personajes que quedan en las casas
        bw.write("houses: ");
        bw.newLine();
        bw.write("------");
        bw.newLine();          
        House h;
        Iterator<House> it = housesMap.values().iterator();
        while(it.hasNext()){
            h = it.next();
            bw.write(h.toString());
            bw.newLine();
            for(Character c: h.getCharacters()){
               bw.write(c.toString());
               bw.newLine();
            }
            bw.newLine();
        }
    }

    /**
     * Metodo que escribe en el fichero de salida la lista de varitas que hay en el castillo.
     * @param bw: Flujo de salida del fichero
     * @param listWands: Lista de varitas
     */
    public void showWands(BufferedWriter bw, ArrayList<Wand> listWands) throws IOException{
        bw.write("new wands:");
        bw.newLine();
        bw.write("--------");
        bw.newLine();       
        for(Wand w: listWands){
            bw.write(w.toString());
            bw.newLine();
        }
    }
    
    /**
     * Metodo que escribe en el fichero de salida los personajes derrotados que han ido al calabozo
     * @param bw: Flujo de salida del fichero
     * @param listDungeon: Lista de personajes que han ido al calabozo
     */
    public void showFinalDungeon(BufferedWriter bw, ArrayList<Character> listDungeon) throws IOException{
        bw.write("dungeon characters:");
        bw.newLine();
        bw.write("-------------------");
        bw.newLine(); 
        for(Character c: listDungeon){
               bw.write(c.toString());
               bw.newLine();
        }
        bw.newLine();
        
    }
    
    /**
     * Metodo que muestra los personajes que van a participar en un duelo.
     * @param bw: Flujo de salida del fichero
     * @param listCharacters: Lista de personajes de la casa
     */
    public void showCharactersDuel(BufferedWriter bw, ArrayList<Character> listCharacters) throws IOException{
        for(Character c: listCharacters){
           bw.write(c.toString());
           bw.newLine();
        }
    }
    
      
    /**
     * Conjunto de duelos que se producen en cada turno. Este método escribe en el fichero creado todos los resultados de la simulación.
     */
    public void duels(int numero) throws IOException{
        int turns = 10;
        BufferedWriter bw = null;
        
        if(numero == 1){
        bw = new BufferedWriter(new FileWriter("output1.log"));
        }
        
        if(numero == 2){
        bw = new BufferedWriter(new FileWriter("output2.log"));
        }
        //Mostrar todas las casas con sus personajes.
        bw.newLine();
        this.showCharactersHouses(bw, this.housesMap);      
        //Mostramos la lista de varitas.
        this.showWands(bw, this.wands);
        bw.newLine();
        
        
        for(int i=0 ; i < turns ; i++ ){
            this.solicitCharacters();
            this.charactersDuel = this.orderCharactersByEnergy();
            
            bw.write("turn: <"+ i + ">");
            bw.newLine();
            
            //Muestro participantes de los duelos en el turno actual.
            bw.write("characters who are going to duel: ");
            bw.newLine();
            bw.write("-----------------------------------");
            bw.newLine();
            this.showCharactersDuel(bw, this.charactersDuel);
            
            bw.newLine();
            bw.newLine();
            bw.write("duels:");
            bw.newLine();
            bw.write("-----");
            bw.newLine();            
            for(Character c : this.charactersDuel){
                for(Character oponent : this.charactersDuel){
                    if(!c.equals(oponent)){
                        bw.write("<"+c.getName() +">" + " is dueling against " + "<" + oponent.getName() + ">");
                        bw.newLine();
                        if(c.getEnergy() > 0 && oponent.getEnergy() > 0){
                            bw.write("attack points of <" + c.getName()+ "> are: <" + c.AttackPointsWand() + ">");
                            bw.newLine();
                            bw.write("resistance points of <" + oponent.getName()+ "> are: <" + oponent.resistancePointsWand() + ">");
                            bw.newLine();
                            c.fight(oponent);
                            bw.write("the remaining energy of <" + oponent.getName() + "> "+"after the duel are: <"+oponent.getEnergy() + ">");
                            bw.newLine();
                            bw.newLine();
                        }
                    }
                }
                
            }
   
            
            //Resultados del duelo
            bw.newLine();         
            bw.newLine();
            bw.write("duel results:");
            bw.newLine();
            bw.write("-----------");
            bw.newLine();
            for(int j=0; j<this.charactersDuel.size(); j++){
                Character c1 = this.charactersDuel.get(j);
                bw.newLine();
                if(c1.getEnergy() > 0){
                    if(!this.wands.isEmpty()){
                        bw.write("character:"+c1.toString()+ " returns to the house");
                        this.asignNewWand(c1);
                        bw.write("new wand assigned: <"+ c1.getNameWand() + " (class "+ c1.getNameClassWand() +")>");
                        bw.newLine();                   
                    }
      
                }else {
                    bw.write("character:"+c1.toString()+ " go to dungeon");
                    this.addDungeon(c1);
                    for(House h : this.housesMap.values()){
                        if(h.getCharacters().contains(c1)){
                            h.getCharacters().remove(c1);
                        }
                    }
                }
            }
        
            bw.newLine();         
            bw.newLine();     
            
            this.charactersDuel.clear();
        }
        
        //Mostrar resultados finales
        bw.write("end of the simulation:");
        bw.newLine();
        bw.write("----------------------");
        bw.newLine();      
        
        //Mostramos los personajes que quedan en las casas.
        this.showCharactersHouses(bw,housesMap);       
        //Mostramos la lista de varitas restantes.
        this.showWands(bw, this.wands);      
        //Mostramos la lista de personajes en el calabozo.
        this.showFinalDungeon(bw, this.dungeon);
        
        //Casa ganadora
        bw.write("the winner house is:");
        bw.newLine();
        bw.write("-------------------");
        bw.newLine();
        
        bw.write(this.winnerHouseBySize().toString());
        bw.newLine();
        for(Character c: this.winnerHouseBySize().getCharacters()){
            bw.write(c.toString());
            bw.newLine();
        }
        bw.newLine();
                
        //Cerramos flujo fichero.
        bw.flush();
        bw.close();
    }
    
    
}
