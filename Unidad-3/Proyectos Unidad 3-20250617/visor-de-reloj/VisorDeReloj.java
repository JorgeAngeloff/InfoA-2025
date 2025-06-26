
/**
 * La clase VisorDeReloj implementa un reloj digital para un etilo de
 * hora Europeo de 24 horas. El reloj muestra horas y minutos. El rango
 * del reloj es 00:00 (medianoche) a 23:59 (un minuto antes de medianoche)
 * The ClockDisplay class implements a digital clock display for a
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class VisorDeReloj
{
    private VisorDeNumeros horas;
    private VisorDeNumeros minutos;
    private String cadVisor;    // simula el visor real
    private String periodo;  // "AM" o "PM"

    /**
     * Constructor de objetos de VisorDeReloj. Este constructor
     * crea un nuevo reloj puesto en hora con el valor 00:00.
     */
    public VisorDeReloj()
    {
        horas   = new VisorDeNumeros(24);
        minutos = new VisorDeNumeros(60);
        actualizarVisor();
    }

    /**
     * Constructor de objetos de VisorDeReloj. Este constructor
     * crea un nuevo reloj puesto en hora con el valor especificado 
     * por los parametros.
     */
    public VisorDeReloj(int hora, int minuto)
    {
        horas   = new VisorDeNumeros(24);
        minutos = new VisorDeNumeros(60);
        ponerEnHora(hora, minuto);
    }

    /**
     * Este m�todo debe invocarse una vez por cada minuto; hace
     * que el visor visor avance un minuto.
     */
    public void ticTac()
    {
        minutos.incrementar();
        if(minutos.getValor() == 0) {  // alcanz� el l�mite!
            horas.incrementar();
        }
        actualizarVisor();
    }
    
    public void incrementaHora()
    { horas.incrementar();
        actualizarVisor();
        
    
    }

    /**
     * Pone en hora el reloj con la hora y los minutos especificados.
     */
    public void ponerEnHora(int hora, int minuto)
    {
        horas.setValor(hora);
        minutos.setValor(minuto);
        actualizarVisor();
    }

    /**
     * Retorna la hora actual del visor en ele formato HH:MM.
     */
    public String getHora()
    {
        return cadVisor;
    }
    
    /**
       Actualiza la cadena interna que representa al visor.
     */
    private void actualizarVisor()
    {
    cadVisor = horas.getValorDelVisor() + ":" + 
    minutos.getValorDelVisor();
               
                            
    /** int hora24 = horas.getValor();
    int hora12;
    
    if (hora24 == 0) {
        hora12 = 12;
        periodo = "AM";
    } else if (hora24 < 12) {
        hora12 = hora24;
        periodo = "AM";
    } else if (hora24 == 12) {
        hora12 = 12;
        periodo = "PM";
    } else {
        hora12 = hora24 - 12;
        periodo = "PM";
    }
    
    String horaFormateada;
    if (hora12 < 10) {
    horaFormateada = "0" + hora12;
    } else {
    horaFormateada = "" + hora12;
    }
    
    cadVisor = horaFormateada + ":" + minutos.getValorDelVisor() + " " + periodo;             
        
    }
*/}
}