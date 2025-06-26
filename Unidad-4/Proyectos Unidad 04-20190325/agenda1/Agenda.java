import java.util.ArrayList;
import java.util.Iterator;


public class Agenda
{
    // Espacio para almacenar un n�mero arbitrario de notas.
    private ArrayList<String> notas;

    /**
     * Realiza cualquier inicializacion que sea requerida para 
     * la agenda
     */
    public Agenda()
    {
        notas = new ArrayList<String>();
    }

    /**
     * Almacena una nueva nota en la agenda.
     * @param nota La nota a ser almacenada.
     */
    public void guardarNota(String nota)
    {
        notas.add(nota);
    }
    
    public void eliminarNota(int numeroDeNota)
    {
      
      if(numeroDeNota < 0) {
          System.out.println("Numero de nota no valido.");

        }
        else if(numeroDeNota < numeroDeNotas()) {
            // Es un n�mero de nota v�lido,por lo tanto dse la puede mostrar.
          notas.remove(numeroDeNota);
        }
        else {
        System.out.println("Numero de nota no valido.");

        }
      
    }

    /**
     * @return El n�mero de notas que tiene actualmente la agenda.
     */
    public int numeroDeNotas()
    {
        return notas.size();
    }

    /**
     * Muestra una nota.
     * @param numeroDeNota El n�mero de nota que se mostrar�.
     */
    public void mostrarNota(int numeroDeNota)
    {
        if(numeroDeNota < 0) {
            System.out.println("Numero de nota no valido.");
        }
        else if(numeroDeNota < numeroDeNotas()) {
            // Es un n�mero de nota v�lido,por lo tanto dse la puede mostrar.
            System.out.println(notas.get(numeroDeNota));
        }
        else {
            System.out.println("Numero de nota no valido.");

        }
    }
    
public void listarTodasLasNotas() {
    for (String nota : notas) {
    System.out.println(nota);


    }
}
public void listarTodasLasNotasConIndice() {
    for (int i=0; i<notas.size();i++) {
    System.out.println(i+": "+notas.get(i));


    }
}
public void listarTodasLasNotasIterator() {
    Iterator<String> it = notas.iterator();  // pedís el iterador
    while (it.hasNext()) {
        String nota = it.next();             // sacás el siguiente
        System.out.println(nota);
    }
}

public void prueba()
{
 int i =10;   
while(i<=95)
{if(i%5==0){
    System.out.println(i);

}
 i++;   

}
}

public void sumar(int a, int b) {
    int suma = 0;
    
    if (a < b) {
        while (a <= b) {
            suma += a; // suma = suma + a;
            a++;
        }
    } else if (a > b) {
        while (a >= b) {
            suma += b; // suma = suma + b;
            b++;
        }
    } else { // a == b
        suma = a; // o suma = b;
    }
    
    System.out.println("La suma es: " + suma);
}
public void buscar(String cadABuscar)
{
int indice=0;
boolean encontrado=false;
int tamanoNotas=notas.size();
while(indice<tamanoNotas && !encontrado)
{
    String nota= notas.get(indice);
    if(nota.contains(cadABuscar)){
    encontrado=true;
    System.out.println("Coincidencia con la nota "+indice+" :");
    System.out.println(notas.get(indice));
    }
    else{
    indice++;
    }
}
if(encontrado==false){
System.out.println("No hubo coincidencia en ninguna nota :(");
}

}

}



