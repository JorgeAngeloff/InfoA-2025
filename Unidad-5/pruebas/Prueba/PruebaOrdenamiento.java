import java.util.TreeSet;
/**
 * Write a description of class PruebaOrdenamiento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PruebaOrdenamiento
{
    // instance variables - replace the example below with your own
    private TreeSet<Integer> lista;

    /**
     * Constructor for objects of class PruebaOrdenamiento
     */
    public PruebaOrdenamiento()
    {
        // initialise instance variables
        this.lista=new TreeSet<>();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void orden(int arreglo[])
    {
        for(Integer num:arreglo)
        {
            lista.add(num);
        
        }
    System.out.println(lista);
    
    }
}