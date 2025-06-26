
/**
 * La clas
 */
public class VisorDeNumeros
{
    private int limite;
    private int valor;

    /**
     * Constructor de objetos de la clases VisorDeNumeros
     * Establece el lte en el cual el visor vueve a cero.
     */
    public VisorDeNumeros(int limiteMaximo)
    {
        limite = limiteMaximo;
        valor = 0;
    }

    /**
     * Retorna el valor actual.
     */
    public int getValor()
    {
        return valor;
    }

    /**
     * Configura el valor del visor con el nuevo valor especificado.
     * Si el nuevo valor es menor que cero o si se pasa del l�mite no
     * hace nada.
     */
    public void setValor(int nuevoValor)
    {
        if((nuevoValor >= 0) && (nuevoValor < limite)) {
            valor = nuevoValor;
        }
    }
    
    /**
     * Devuelve el n�mero del visor (es decir, el valor actual, como una cadena 
     * de dos d�gitos. Si el valor es menor que 10, se completa con un cero).
     */
    public String getValorDelVisor()
    {
        if(valor < 10) {
            return "0" + valor;
        }
        else {
            return valor + "";
        }
        // if (valor == 0 && limite == 12) {
       //     return "12";
     //}
       // if (valor < 10) {
     //       return "0" + valor;
     //}
       //     return "" + valor;
        
        
    }

    /**
     * Incrementa el valor del visor en uno, lo vuelve a cero si se alcanza
     * el valor l�mite.
     */
    public void incrementar()
    {
        valor = (valor + 1) % limite;
    
        // valor = valor + 1;
        //if(valor>limite){
        //valor = 0;
        //}
    }
}
