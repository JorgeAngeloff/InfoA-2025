
public class Persona {
    // Atributos
    private String nombre;
    private int dni;
    private int edad;

    //Constructor
    public Persona (String nombre, int dni, int edad){
        setNombre(nombre);
        setDni(dni);
        setEdad(edad);
    }
    
    /**
     *  Debe verificarse que nombre no sea una cadena vacia
     *  (utilizar metodo length de String), asignar el valor y devolver true. 
     *  En caso contrario asignar "" (cadena vacia) y retornar false.
     */
    
    public boolean setNombre(String nombre){
        int lengthNombre= nombre.length();
        
        if(lengthNombre==0){
            this.nombre="";
            return false;
        }
        else{
        this.nombre=nombre;
        return true;
        }
    }
    
    /**
     * Retorna el valor de nombre
     */
     public String getNombre (){
        return this.nombre;
    }
    
    /**
     *   Debe verificarse que dni  se encuentre entre 0 y 99999999, asignar el valor
     *   y devolver true. En caso contrario asignar -1 y retornar false. 
     */
    
    public boolean setDni(int dni){
       if(dni>=0 && dni<=99999999){
        this.dni=dni;
        return true;
        }
        else{
        this.dni=-1;
        return false;
        }
    }
    
    /**
     * Retorna el valor de dni
     */
     public int getDni (){
        return this.dni; 
    }
    
    /**
     *  Debe verificarse que edad se encuentre entre 0 y 120 asignar el valor y devolver true. 
     *  En caso contrario asignar -1 y retornar false.
     */
    
    public boolean setEdad(int edad){
       if(edad>=0 && edad<=120){
        this.edad=edad;
        return true;
        }
        else{
        this.edad=-1;
        return false;
        }
    }
    
    /**
     * Retorna el valor de edad
     */
    public int getEdad (){
        return this.edad;
    }

}