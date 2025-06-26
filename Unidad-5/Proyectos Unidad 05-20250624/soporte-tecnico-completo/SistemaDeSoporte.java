import java.util.HashSet;

/**
 * rio y un objecto de clase Contestador para generar las 
 * respuestas. Contiene un ciclo que repetidamente lee las entradas y
 * genera las respuestas hasta que el usuario decide salir.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    1.0
 */
public class SistemaDeSoporte
{
    private LectorDeEntrada lector;
    private Contestador contestador;
    
    /**
     * Crea un sistema de soporte tcnico.
     */
    public SistemaDeSoporte()
    {
        lector = new LectorDeEntrada();
        contestador = new Contestador();
    }

    /**
     * Inicia el sistema de soporte t�cnico. Imprimir� un mensaje de bienvenida
     * y establece un di�logo con el usuario hasta que el usuario lo finalice.
     */
    public void iniciar()
    {
        boolean terminado = false;

        imprimirBienvenida();

        while(!terminado) {
            HashSet<String> entrada = lector.getEntrada();

            if(entrada.contains("bye")) {
                terminado = true;
            }
            else {
                String respuesta = contestador.generarRespuesta(entrada);
                System.out.println(respuesta);
            }
        }
        imprimirDespedida();
    }

    /**
     * Imprime un mensaje de Bienvenida en la pantalla
     */
    private void imprimirBienvenida()
    {
        System.out.println("Bienvenido al Sistema de Soporte T�cnico de DodgySoft.");
        System.out.println();
        System.out.println("Por favor, cu�ntenos de su problema.");
        System.out.println("Lo asistiremos con cualquier problema que tenga.");
        System.out.println("Para salir del sistema escriba 'bye'.");
    }

    /**
     * Imprime un mensaje de Despedida en la pantalla
     */
    private void imprimirDespedida()
    {
        System.out.println("Un gusto hablar con usted. Bye...");
    }
}
