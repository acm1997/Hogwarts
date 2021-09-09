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
public class initData2
{
    private Hogwarts hogwarts = Hogwarts.getInstance();

    /**
     * Constructor for objects of class initData
     */
    public initData2()
    {
        initData2(); 
    }

    private void initData2(){
        
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
        hogwarts.newWand(new HollyDefensive("Cypress"));
        hogwarts.newWand(new HollyDefensive("Ebony"));
        hogwarts.newWand(new OffensiveHawthorn("Reed"));
        hogwarts.newWand(new HollyDefensive("Aspen"));
        hogwarts.newWand(new OffensiveHawthorn("Walnut"));
        hogwarts.orderWands();
         
        //Nuevos Personajes en Gryffindor
        House gryffindor = new orderDefensive("Gryffindor");
        
        Character harry = new Offensive("Harry Potter", 20.0, 20.0, new HollyDefensive("HarryW"));
        harry.asignExtraPotion(new InvigorationPotion());
        harry.asignExtraPotion(new FelixFelicisPotion());
        harry.useExtraPotion(new InvigorationPotion());
        harry.useExtraPotion(new FelixFelicisPotion());
        
        Character hermione = new Offensive("Hermione Granger",20.0,20.0,new HollyDefensive("HermioneW"));
        hermione.asignExtraPotion(new FelixFelicisPotion());
        hermione.asignExtraPotion(new InvigorationPotion());
        hermione.useExtraPotion(new FelixFelicisPotion());
        hermione.useExtraPotion(new InvigorationPotion());
        
        Character ron = new Offensive("Ron Weasley",20.0,20.0,new HollyDefensive("RonW")); 
        ron.asignExtraPotion(new FelixFelicisPotion());
        ron.useExtraPotion(new FelixFelicisPotion());

        gryffindor.addMember(harry);
        gryffindor.addMember(hermione);
        gryffindor.addMember(ron); 
        
                gryffindor.orderCharacters();
        hogwarts.putHouse(gryffindor);       
                
        //Nuevos Personajes en Hufflepuff
        House hufflepuff = new orderDefensiveReverse("HufflepuffHouse");
        Character cedric = new Defensive("Cedric Diggory",20.0, 20.0,new OffensiveHawthorn("CedricW"));   
        cedric.asignExtraPotion(new InvigorationPotion());
        cedric.useExtraPotion(new InvigorationPotion());
        
        Character nymphadora = new Defensive("Nymphadora Tonks", 20.0, 20.0,new OffensiveHawthorn("NymphadoraW"));
        
        Character pomona = new Defensive("Pomona Sprout", 20.0, 20.0, new OffensiveHawthorn("PomonaW"));
        pomona.asignExtraPotion(new FelixFelicisPotion ());
        pomona.useExtraPotion(new FelixFelicisPotion ());
       
        Character rolf = new Defensive("Rolf Scamander", 20.0, 20.0, new OffensiveHawthorn("RolfW"));
        
        Character silvanus = new Defensive("Silvanus Kettleburn", 20.0, 20.0, new OffensiveHawthorn("SilvanusW"));
        silvanus.asignExtraPotion(new FelixFelicisPotion ());
        silvanus.useExtraPotion(new FelixFelicisPotion ());
        
        Character susan = new Defensive("Susan Bones", 20.0, 20.0, new OffensiveHawthorn("SusanW"));
   
        Character newton = new Defensive("Newton Scamander", 20.0, 20.0 , new OffensiveHawthorn("NewtonW"));
     
        Character hannah = new Defensive("Hannah Abbott",20.0 , 20.0, new OffensiveHawthorn("HannahW") );
        hannah.asignExtraPotion(new FelixFelicisPotion());
        hannah.useExtraPotion(new FelixFelicisPotion());
        
        hufflepuff.addMember(cedric);
        hufflepuff.addMember(nymphadora);
        hufflepuff.addMember(pomona);
        hufflepuff.addMember(rolf);
        hufflepuff.addMember(silvanus);
        hufflepuff.addMember(susan);
        hufflepuff.addMember(newton);
        hufflepuff.addMember(hannah);
        
                hogwarts.putHouse(hufflepuff);

        hufflepuff.orderCharacters();

        
        //Nuevos Personajes en Slytherin 
        House slytherin = new orderOffensiveReverse("Slytherin");
        
        Character draco = new Defensive("Draco Malfoy", 20.0, 20.0, new HollyDefensive("DracoW"));
        draco.asignExtraPotion(new FelixFelicisPotion());
        draco.useExtraPotion(new FelixFelicisPotion());

        slytherin.addMember(draco);
        
        hogwarts.putHouse(slytherin);

        slytherin.orderCharacters();        

        //Nueva casa RavenclawHouse
        House RavenclawHouse = new orderNameWand("RavenclawHouse");
        
        Character luna = new Defensive("Luna Lovegood", 20.0,20.0,new OffensiveHawthorn("LunaW"));
        luna.asignExtraPotion(new InvigorationPotion());
        luna.useExtraPotion(new InvigorationPotion());
        
        Character cho = new Offensive("Cho Chang", 20.0,20.0, new OffensiveHawthorn("ChoW")) ;        
        cho.asignExtraPotion(new FelixFelicisPotion());
        cho.useExtraPotion(new FelixFelicisPotion());
        
        Character filius = new Defensive("Filius Flitwick", 20.0,20.0, new OffensiveHawthorn("FiliusW")); ;
        filius.asignExtraPotion(new InvigorationPotion());
        filius.asignExtraPotion(new FelixFelicisPotion());
        filius.useExtraPotion(new InvigorationPotion());
        filius.useExtraPotion(new FelixFelicisPotion());
        
        RavenclawHouse.addMember(luna);
        RavenclawHouse.addMember(cho);
        RavenclawHouse.addMember(filius);
        
        hogwarts.putHouse(RavenclawHouse);
        
        RavenclawHouse.orderCharacters();
    
    }
    
    public void simulation(int numero) throws IOException{
        this.hogwarts.duels(numero);
    }
}
