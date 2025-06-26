import java.util.HashSet;
import java.util.ArrayList;

public class Aula {
  private String materia;
  private ArrayList<Alumno> listado;
    
    //Constructor
    public Aula (String materia){
        this.materia = materia;
        this.listado = new ArrayList<Alumno>();
    }
    
    //Metodos
    //getters
    public String getMateria (){
        return materia;
    }

   /**
   * Este metodo devuelve la coleccion que contiene los alumnos 
   * pertenecientes al curso. 
   * @return La coleccion con el listado de alumnos.
   */
    public ArrayList<Alumno> getListado(){
        
        return listado;
        
        
    }
    
   /**
   * Este metodo devuelve el objeto del tipo Alumno en la posicion
   * i de la coleccion.
   * @param  i  El indice solicitado
   * @return El alumno con indice i.
   */
    public Alumno getAlumno(int i){
        return listado.get(i);   
    }
    //setters
    public void setMateria (String materia){
        this.materia=materia;
    }

   /**
   * Este metodo permite agregar un alumno a la coleccion elegida   
   * @param alumno Alumno que se desea agregar a la coleccion.
   */
    public void agregarAlumno (Alumno alumno){
        listado.add(alumno);
        
    }
}