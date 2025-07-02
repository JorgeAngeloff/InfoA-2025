import java.util.HashSet;

/**
 * La clase SistemaDeSoporte modela un sistema de soporte técnico simple
 * que permite al usuario describir un problema mediante palabras clave
 * y obtiene respuestas generadas automáticamente.
 * 
 * Este sistema utiliza un objeto de clase {@link LectorDeEntrada} para leer
 * las palabras ingresadas por el usuario, y un objeto de clase {@link Contestador}
 * para generar una respuesta adecuada.
 * 
 * El ciclo de atención continúa hasta que el usuario escribe "bye".
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 1.0
 */
public class SistemaDeSoporte
{
    private LectorDeEntrada lector;
    private Contestador contestador;
    
    /**
     * Crea un nuevo sistema de soporte técnico inicializando
     * el lector de entrada y el generador de respuestas.
     */
    public SistemaDeSoporte()
    {
        lector = new LectorDeEntrada();
        contestador = new Contestador();
    }

    /**
     * Inicia el sistema de soporte técnico.
     * Muestra un mensaje de bienvenida, lee la entrada del usuario,
     * y genera respuestas hasta que el usuario escriba "bye".
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
     * Muestra un mensaje de bienvenida en la consola.
     */
    private void imprimirBienvenida()
    {
        System.out.println("Bienvenido al Sistema de Soporte Técnico de DodgySoft.");
        System.out.println();
        System.out.println("Por favor, cuéntenos su problema.");
        System.out.println("Lo asistiremos con cualquier problema que tenga.");
        System.out.println("Para salir del sistema escriba 'bye'.");
    }

    /**
     * Muestra un mensaje de despedida en la consola.
     */
    private void imprimirDespedida()
    {
        System.out.println("Un gusto hablar con usted. Bye...");
    }
}
