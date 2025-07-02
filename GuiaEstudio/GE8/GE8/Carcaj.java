/**
 * Modela el Carcaj que lleva el personaje para
 * tranportar sus flechas.
 */
public class Carcaj extends Recipiente implements Portable {
    private final Integer PESO_PROPIO = 10;
    private Integer capacidad;
    private List<Flecha> flechas;
    private EstadoContenedor estado;

    /**
     * Constructor para un Carcaj generico chico. Su capacidad
     * es de 5 flechas y se inicializa en estado vacio (ver
     * Arroyo y Barrica a modo de ejemplo de los estados).
     * Recordar que tiene peso inicial.
     */
    public Carcaj () {
        // TODO - Implementar constructor
        estado = new Vacio();
        flechas = new ArrayList<>();
        capacidad = 5;
        setNombre("Carcaj chico");
        setPeso(PESO_PROPIO);
    }
    
    /**
     * Constructor para un Carcaj de nombre y capacidad indicados
     * por parametro.  Se inicializa en estado vacio (ver
     * Arroyo y Barrica a modo de ejemplo de los estados)
     * Recordar que tiene peso inicial.
     *
     * @param nombre El nombre del carcaj.
     * @param capacidad Cantidad maxima de flechas.
     */
    public Carcaj (String nombre, Integer capacidad) {
        // TODO - Implementar constructor
        setNombre(nombre);
        this.capacidad = capacidad;
        estado = new Vacio();
        flechas = new ArrayList<>();
        setPeso(PESO_PROPIO);
    }
    
/*
 ************* Patron State *************
 */
    /**
     * Delegate methods para acceder a los metodos apropiados
     * en base al estado del objeto.
     * 
     * Agrega una flecha al carcaj.
     * 
     * Debe actualizarse el peso total.
     * 
     * @param flecha La flecha a agregar.
     * @throws ContenedorLlenoException En caso que el carcaj se
     *               encuentre en su capacidad maxima con el
     *               mensaje: "Carcaj lleno".
     * @throws AccionNoPermitidaException En caso que el elemento no sea
     *               una flecha  con el mensaje: "Carcaj no admite <elemento>"
     *               (<elemento> == nombre del elemento).
     */
    public void addFlecha(Elemento elemento) throws ContenedorLlenoException, AccionNoPermitidaException {
        // delegate method a getElemento() de la interfaz
        estado.addElemento(elemento);
    }
    @Override
    public void addElemento(Elemento elemento) throws ContenedorLlenoException, AccionNoPermitidaException {
        // delegate method a getElemento() de la interfaz
        estado.addElemento(elemento);
    }

    /**
     * Delegate methods para acceder a los metodos apropiados
     * en base al estado del objeto.
     * 
     * Devuelve una flecha del carcaj como Elemento.
     * 
     * Debe actualizarse el peso total.
     * 
     * @return Una flecha.
     * @throws ContenedorVacioException En caso que el carcaj se
     *               encuentre vacio con el mensaje: "Carcaj vacio".
     * @throws AccionNoPermitidaException No aplica.
     */
    public Elemento getFlecha () throws ContenedorVacioException, AccionNoPermitidaException {
        // delegate method a getElemento() segun estado
        return estado.getElemento();
    }
    @Override
    public Elemento getElemento () throws ContenedorVacioException, AccionNoPermitidaException {
        // delegate method a getElemento() segun estado
        return estado.getElemento();
    }

    /**
     * Se utiliza la version implementada en EstadoContenedor,
     * que siempre lanza la excepcion AccionNoPermitidaException.
     */    
    @Override
    public Elemento getElemento (String nombre) throws ContenedorVacioException, AccionNoPermitidaException {
        // delegate method a getElemento() segun estado
        return estado.getElemento(nombre);
    }


    /**
     * Implementar los metodos de las clases privadas que sean
     * necesarios para cada estado.
     * 
     * No olvidar contemplar las situaciones que producen
     * el cambio a otro estado.
     * 
     * Ver lo implementado en Arroyo y Barrica. Considerar
     * las pautas en Botella.
     */

    /**
     * La clase VACIO indica el estado del Carcaj sin flechas.
     * Debe cambiar al estado CONFLECHAS al agregarse una flecha.
     */
    // TODO - Implementar la clase privada
    private class Vacio extends EstadoContenedor {
        public void addElemento(Elemento flecha) throws AccionNoPermitidaException
        {
            if(!(flecha instanceof Flecha))
            {
                throw new AccionNoPermitidaException("Carcaj no admite " + flecha.getNombre());
            }
            addPeso(flecha.getPeso());
            flechas.add((Flecha)flecha);
            estado = new ConFlechas();
        }
        
        public Elemento getElemento() throws ContenedorVacioException, AccionNoPermitidaException
        {
            throw new ContenedorVacioException("Carcaj vacio");
        }

        @Override
        public String toString() {
            return " sin flechas (vacio)";
        }
    }

    /**
     * La clase CONFLECHAS indica el estado del Carcaj con flechas.
     * Debe cambiar al estado VACIO al quitarse la ultima flecha.
     * Debe cambiar al estado LLENO al agregar una flecha que complete
     * la capacidad maxima.
     */
    // TODO - Implementar la clase privada
    private class ConFlechas extends EstadoContenedor {
        public void addElemento(Elemento flecha) throws AccionNoPermitidaException
        {
            if(!(flecha instanceof Flecha))
            {
                throw new AccionNoPermitidaException("Carcaj mo admite " + flecha.getNombre());
            }
            
            addPeso(flecha.getPeso());
            flechas.add((Flecha) flecha);
            
            if(flechas.size() == capacidad)
            {
                estado = new Lleno();
            }
        }
        
        public Elemento getElemento() throws ContenedorVacioException, AccionNoPermitidaException
        {
            Elemento flecha = flechas.get(0);
            addPeso(-1 * flecha.getPeso());
            flechas.remove(0);
            if(flechas.size() == 0)
            {
                estado = new Vacio();
            }
            return flecha;
        }

        @Override
        public String toString() {
            return " con " + getCantidadFlechas() + " flechas";
        }
    }

    /**
     * La clase LLENO indica el estado del Carcaj con flechas.
     * Debe cambiar al estado CONFLECHAS al quitarse una flecha.
     */
    // TODO - Implementar la clase privada
    private class Lleno extends EstadoContenedor {
        public void addFlecha (Elemento flecha) throws ContenedorLlenoException, AccionNoPermitidaException 
        {
            throw new ContenedorLlenoException("Carcaj lleno");
        }
        
        public Elemento getElemento () throws ContenedorVacioException, AccionNoPermitidaException 
        {
            Elemento flecha = flechas.get(0);
            addPeso(-1 * flecha.getPeso());
            flechas.remove(0);
            estado = new ConFlechas();
            return flecha;
        }

        @Override
        public String toString() {
            return " con " + getCantidadFlechas() + " flechas (lleno)";
        }
    }
/*
 ************* FIN Patron State *************
 */

    /**
     * Modifica el peso del carcaj.
     * Puede sumar o restar peso.
     *
     * @param peso El peso a modificar.
     */
    public void addPeso (Integer peso) {
        setPeso(getPeso() + peso);
    }

    /**
     * Devuelve informacion sobre el carcaj de la forma:
     *     "<nombre> <estado>"
     * donde <nombre> es el nombre del carcaj y
     * <estado> es el toString de cada estado.
     */
    @Override
    public String toString() {
        // TODO - Implementar metodo
        return getNombre() + estado.toString();
    }

    public Integer getCantidadFlechas () {
        return flechas.size();
    }

    public Integer getCapacidad () {
        return capacidad;
    }

    public EstadoContenedor getEstado () {
        return estado;
    }

}