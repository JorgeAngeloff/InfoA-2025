public class Portatil extends PC
{
    private double duracionBat ;
    
    /**
     * Constructor por defecto. 
     * Inicializa duracionBat en 100.
     */
    public Portatil()
    {
    duracionBat=100;
        
    }
    
    /**
     * Constructor con parametros.
     * @param memoria La memoria asignada al equipo en GB
     * @param procesadores La cantidad de procesadores
     * @param pantalla El tamanio de la pantalla en pulgadas
     * @param marca La marca de los procesadores
     * @param duracion La duracion inicial de la bateria
     */
    public Portatil(int memoria,int procesadores, int pantalla,
            MarcaProcesador marca,double duracion){
    super(memoria, procesadores, pantalla,marca);
    duracionBat=duracion;
                
    }
    /**
     * Incrementa la cantidad de bateria disponible con el 
     * valor de carga.
     * @param carga La cantidad de carga a incrementar
     */
    public void cargar(double carga)
    {
    duracionBat+=carga;
        
    }
    
     /**
     * Decrementa la cantidad de bateria disponible con el
     * valor de consumo. Solo se descargara la bateria cuando
     * el equipo este encendido.
     * En caso de que el valor de bateria alcance el valor 
     * cero o un valor inferior el equipo debera apagarse y
     * el valor de bateria disponible quedara en cero.
     * 
     * @param consumo La cantidad de carga a decrementar
     * 
     * @return Devuelve true si consigue descargar la bateria y false
     * si no consigue descargar la bateria.
     */
    public boolean descargar(double consumo){
        if(encendido==true)
        {duracionBat-=consumo;
            if(duracionBat<=0)
            {
            encendido=false;
            duracionBat=0;
            }
        
        
        }
        
        return encendido;// no olvide modificar esta linea
    }
    /**
     * Devuelve el valor actual de la carga.
     */
    public Double getCarga (){
        return duracionBat; // no olvide modificar esta linea
    }
    /**
     * @return Una cadena con formato:
     * Memoria: 2 gb 
     * Procesadores: 2 INTEL 
     * Pantalla: 14 pulgadas
     * Bateria actual: 80.2 
     */    
    public String toString(){
        String salida= "Memoria: "+super.getMemoria()+" gb\nProcesadores: "+procesadores+" "+marca+"\nPantalla: "+pantalla+" pulgadas\nBateria Actual: "+duracionBat;
        return salida; // no olvide modificar esta linea
        
        "Memoria: 4 gb\nProcesadores: 2 AMD\nPantalla: 15 pulgadas\nBateria actual: 80.2",
 
    }
}
