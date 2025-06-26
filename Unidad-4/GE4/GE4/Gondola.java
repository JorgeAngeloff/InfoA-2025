import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;

public class Gondola {
    private String pasillo;
    private HashSet<Producto> productos;  // Definir clase de coleccion a utilizar
    
    //Constructor
    public Gondola (String pasillo){
        this.pasillo=pasillo;
        this.productos=new HashSet<Producto>();   
    }
    
    //Metodos
    //getters
    public String getPasillo (){
        return pasillo;
    }

   /**
   * Este metodo devuelve la coleccion que contiene los productos 
   * que se encuentran en la gondola. 
   * @return La coleccion con el listado de productos.
   */
    public HashSet<Producto> getProductos(){  // Definir clase de coleccion 
            return productos;
    }
    
    //setters
    public void setPasillo (String pasillo){
            this.pasillo=pasillo;
    }

   /**
   * Este metodo permite agregar un producto a la coleccion elegida   
   * @param producto El producto que se desea agregar a la coleccion.
   */
    public void agregarProducto (Producto producto){
        productos.add(producto);   
    }
    
    /**
   * Este metodo devuelve la cantidad de productos pertenecientes en la
   * gondola.
   * @return Cantidad de productos en la coleccion.
   */
    public int cantidadProductos (){
        return productos.size();
    }
}