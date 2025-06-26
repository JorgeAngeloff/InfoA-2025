import java.util.HashSet;
import java.util.ArrayList;

public class Catedra {
    private String materia;
    private HashSet<Docente> catedra;
    
    //Constructor
    public Catedra (String materia){
        this.materia = materia;
        this.catedra=new HashSet<Docente>();
        
    }
    
    //Metodos
    //getters
    public String getMateria (){
        return materia;
    }

   /**
   * Este metodo devuelve la coleccion que contiene los docentes 
   * pertenecientes a la catedra. 
   * @return La coleccion con el listado de docentes.
   */
    public HashSet<Docente> getListado(){
        return catedra;  
    }
    
    //setters
    public void setMateria (String materia){
        this.materia=materia;
    }

   /**
   * Este metodo permite agregar un alumno a la coleccion elegida   
   * @param docente Docente que se desea agregar a la coleccion.
   */
    public void agregarDocente (Docente docente){
    catedra.add(docente);

    }
    
    /**
   * Este metodo devuelve la cantidad de docentes pertenecientes a la 
   * catedra.
   * @return Cantidad de docentes en la coleccion.
   */
    public int cantidadDocentes (){
        return catedra.size();

    }
}