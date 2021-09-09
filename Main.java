import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) throws IOException{
        
        System.out.println("Introducir que datos vas a cargar: (1 ó 2) ");
	Scanner reader = new Scanner(System.in);
	int numero = 0; 
	numero = reader.nextInt();
	
	if(numero == 1){
	    initData1 in1 = new initData1();
	    in1.simulation(numero);
	}
	if(numero == 2){
	    initData2 in2 = new initData2();    
	    in2.simulation(numero);
	}
	
	
	
        
    }


}
