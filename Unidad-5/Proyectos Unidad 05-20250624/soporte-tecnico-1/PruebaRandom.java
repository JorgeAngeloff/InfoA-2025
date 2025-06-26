import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class PruebaRandom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PruebaRandom
{
    // instance variables - replace the example below with your own
    private Random aleatorio;

    /**
     * Constructor for objects of class PruebaRandom
     */
    public PruebaRandom()
    {
        // initialise instance variables
        aleatorio=new Random();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void imprimirAleatorio()
    {
        int nro=aleatorio.nextInt();
         System.out.println("Número aleatorio: " + nro);
    }
    public void impimirVariosAleatorios(int cantidad)
    {
    for(int i=0;i<cantidad;i++)
    {imprimirAleatorio();
    
    }
    }
}