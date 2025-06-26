import java.util.HashMap;
/**
 * Write a description of class PruebaMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PruebaMap
{
    // instance variables - replace the example below with your own
    private HashMap<String,String> agenda;

    /**
     * Constructor for objects of class PruebaMap
     */
    public PruebaMap()
    {
        agenda=new HashMap<>();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void ingresarNumero(String nombre, String numero)
    {
        agenda.put(nombre,numero);
    }
    public String buscarNumero(String nombre)
    {
    String contacto=agenda.get(nombre);
    return contacto;
    }
}