import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Clase para iniciar los datos de la simulación.
 *
 * @author Angel Cañada y Juan Manuel Mancera.
 * @version 5-12-2019
 * Nombre del grupo: HogwartsAJ
 */
public class initData1
{
    private Hogwarts hogwarts = Hogwarts.getInstance();

    /**
     * Constructor for objects of class initData
     */
    public initData1()
    {
        initData1(); 
    }

    private void initData1(){
        
        //Nuevas varitas.
        hogwarts.newWand(new OffensiveHawthorn("Ivy"));
        hogwarts.newWand(new OffensiveHawthorn("Larch"));
        hogwarts.newWand(new HollyDefensive("Rowan"));
        hogwarts.newWand(new OffensiveHawthorn("Yew"));
        hogwarts.newWand(new OffensiveHawthorn("Hazel"));
        hogwarts.newWand(new OffensiveHawthorn("Pine"));
        hogwarts.newWand(new HollyDefensive("Tamarack"));
        hogwarts.newWand(new OffensiveHawthorn("Spruce"));
        hogwarts.newWand(new OffensiveHawthorn("Pear"));
        hogwarts.newWand(new OffensiveHawthorn("Laurel"));
        hogwarts.orderWands();
         
        //Nuevos Personajes en Gryffindor
        House gryffindor = new orderDefensive("Gryffindor");
        
        Character harry = new Offensive("Harry Potter", 27.5, 28.0, new OffensiveHawthorn("HarryW"));
        harry.asignExtraPotion(new InvigorationPotion());
        harry.asignExtraPotion(new FelixFelicisPotion());
        
        Character hermione = new Defensive("Hermione Granger",20.0,30.0,new HollyDefensive("HermioneW"));
        hermione.asignExtraPotion(new FelixFelicisPotion());
        hermione.asignExtraPotion(new InvigorationPotion());
        
        Character ron = new Defensive("Ron Weasley",26.0,20.0,new OffensiveHawthorn("RonW")); 
        ron.asignExtraPotion(new FelixFelicisPotion());
        
        Character neville = new Defensive("Neville Longbottom",20.0,20.0,new OffensiveHawthorn("NevilleW")); 

        gryffindor.addMember(harry);
        gryffindor.addMember(hermione);
        gryffindor.addMember(ron);
        gryffindor.addMember(neville); 
        
                gryffindor.orderCharacters();
        hogwarts.putHouse(gryffindor);       
                
        //Nuevos Personajes en Hufflepuff
        House hufflepuff = new orderOffensive("Hufflepuff");
        Character cedric = new Defensive("Cedric Diggory",20.0, 30.0,new OffensiveHawthorn("CedricW"));   
        cedric.asignExtraPotion(new InvigorationPotion());
        
        Character nymphadora = new Defensive("Nymphadora Tonks", 20.0, 20.0,new OffensiveHawthorn("NymphadoraW"));
        
        Character pomona = new Offensive("Pomona Sprout", 27.5, 20.0, new OffensiveHawthorn("PomonaW"));
        pomona.asignExtraPotion(new FelixFelicisPotion ());
       
        Character rolf = new Defensive("Rolf Scamander", 20.0, 20.0, new OffensiveHawthorn("RolfW"));
        
        hufflepuff.addMember(cedric);
        hufflepuff.addMember(nymphadora);
        hufflepuff.addMember(pomona);
        hufflepuff.addMember(rolf);
        
                hogwarts.putHouse(hufflepuff);

        hufflepuff.orderCharacters();

        
        //Nuevos Personajes en Slytherin 
        House slytherin = new orderOffensiveReverse("Slytherin");
        
        Character draco = new Defensive("Draco Malfoy", 20.0, 20.0, new HollyDefensive("DracoW"));
        draco.asignExtraPotion(new FelixFelicisPotion());
        
        Character dolores = new Offensive("Dolores Umbridge", 20.0, 20.0, new HollyDefensive("DoloresW"));
        
        Character pansy = new Offensive("Pansy Parkinson", 27.5, 20.0, new OffensiveHawthorn("PansyW"));
        draco.asignExtraPotion(new FelixFelicisPotion());
        
        Character albus = new Offensive("Albus Severus Potter", 20.0, 20.0, new HollyDefensive("AlbusW"));

        slytherin.addMember(draco);
        slytherin.addMember(dolores);
        slytherin.addMember(pansy);
        slytherin.addMember(albus);
        
        hogwarts.putHouse(slytherin);

        slytherin.orderCharacters();        


        
    }
    
    public void simulation(int numero) throws IOException{
        this.hogwarts.duels(numero);
    }
}

