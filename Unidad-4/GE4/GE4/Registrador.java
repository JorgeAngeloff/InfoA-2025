import java.util.HashSet;
import java.util.ArrayList;

public class Registrador {
    private String designacion;
    private ArrayList<Registro> registros; 
    
    //Constructor
    public Registrador (String designacion){
    this.designacion=designacion;
    this.registros=new ArrayList<Registro>();
    }
    
    //Metodos
    //getters
    public String getDesignacion (){
        return designacion;
    }

   /**
   * Este metodo devuelve la coleccion que contiene los registros 
   * guardados. 
   * @return La coleccion con el listado de registros.
   */
    public ArrayList<Registro> getRegistros(){ //Definir coleccion apropiada
       return registros;
    }
    
   /**
   * Este metodo devuelve el objeto del tipo Registro en la posicion
   * i de la coleccion.
   * @param  i  El indice solicitado
   * @return El registro con indice i.
   */
    public Registro getRegistro (int i){
        return registros.get(i);
    }
    //setters
    public void setDesignacion (String designacion){
        this.designacion=designacion;
    }

   /**
   * Este metodo permite agregar un registro a la coleccion elegida   
   * @param registro Registro que se desea agregar a la coleccion.
   */
    public void agregarRegistro (Registro registro){
        registros.add(registro);
    }
}