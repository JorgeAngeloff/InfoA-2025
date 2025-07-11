public class Botella extends Recipiente implements Portable {
    private static final Integer PESO_PROPIO = 4;
    private Elemento contenido;
    private EstadoContenedor estado;

    /**
     * Crea una botella para transportar liquido.
     * 
     * Debe inicializarse con el peso propio y en estado vacia.
     */
    public Botella() {
        // TODO - Implementar constructor
        setPeso(PESO_PROPIO);
        estado = new Vacia();
        generarNombre();
    }

/*
 ************* Patron State ************* 
 */
    /**
     * Delegate methods para acceder a los metodos apropiados
     * en base al estado del objeto.
     * 
     * Llena la botella con el liquido indicado agregando el peso del
     * nuevo liquido. Genera el nuevo nombre de la botella y actualiza
     * el peso.
     * 
     * @param liquido El liquido para rellenar la botella
     * @throws ContenedorLlenoException En caso que la botella se
     *               encuentre llena con el mensaje: "Botella llena".
     * @throws AccionNoPermitidaException En caso que el elemento no sea un
     *               liquido con el mensaje: "Botella no admite <elemento>"
     *               (<elemento> == nombre del elemento).
     */
    public void llenarBotella (Elemento liquido) throws ContenedorLlenoException, AccionNoPermitidaException {
        // delegate method a addElemento() de la interfaz
        addElemento(liquido);
    }
    @Override
    public void addElemento (Elemento elemento) throws ContenedorLlenoException, AccionNoPermitidaException {
        // delegate method a addElemento() segun estado
        estado.addElemento(elemento);
    }

    /**
     * Delegate methods para acceder a los metodos apropiados
     * en base al estado del objeto.
     * 
     * Vacia el contenido de la botella y actualiza el peso.
     * La botella queda lista para recargar. Genera el nuevo nombre
     * de la botella y actualiza el peso.
     * 
     * @return El contenido de la botella.
     * @throws ContenedorVacioException En caso que la botella se
     *               encuentre vacia con el mensaje: "Botella vacia".
     * @throws AccionNoPermitidaException No aplica.
     */
    public Elemento vaciarBotella () throws ContenedorVacioException, AccionNoPermitidaException {
        // delegate method a getElemento() de la interfaz
        return getElemento();
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
     * Implementar los metodos de la clase privada que sean
     * necesarios para el estado VACIA.
     * 
     * No olvidar contemplar las situaciones que producen
     * el cambio a otro estado.
     * 
     * Ver lo implementado en Arroyo y Barrica.
     */
    private class Vacia extends EstadoContenedor {     
        @Override
        public void addElemento(Elemento elemento) throws ContenedorLlenoException, AccionNoPermitidaException {
            // TODO - Implementar metodo
            if(!(elemento instanceof Liquido))
            {
                throw new AccionNoPermitidaException("Botella no admite " + elemento.getNombre());
            }
            
            contenido = elemento;
            setPeso(getPeso() + elemento.getPeso());
            estado = new Llena();
            generarNombre();
        }

        @Override
        public Elemento getElemento() throws ContenedorVacioException, AccionNoPermitidaException {
            // TODO - Implementar metodo
            throw new ContenedorVacioException("Botella vacia");
        }

        @Override
        public String toString() {
            return "vacia";
        }
    }

    /**
     * Implementar los metodos de la clase privada que sean
     * necesarios para el estado LLENA.
     * 
     * No olvidar contemplar las situaciones que producen
     * el cambio a otro estado.
     * 
     * Ver lo implementado en Arroyo y Barrica.
     */
    private class Llena extends EstadoContenedor {
        @Override
        public void addElemento(Elemento elemento) throws ContenedorLlenoException, AccionNoPermitidaException {
            // TODO - Implementar metodo
            throw new ContenedorLlenoException("Botella llena");
        }    

        @Override
        public Elemento getElemento() throws ContenedorVacioException, AccionNoPermitidaException {
            // TODO - Implementar metodo
            setPeso(getPeso() - contenido.getPeso());
            estado = new Vacia();
            generarNombre();
            
            return contenido;
        }

        @Override
        public String toString() {
            return "con " + contenido;
        }
    }
/*
 ************* FIN Patron State ************* 
 */

    /**
     * Establece la descripcion de la botella con su contenido
     * correspondiente, por ej. "Botella con Agua".
     * En caso de que no tenga contenido, utiliza el texto
     * "Botella vacia"
     */
    public void generarNombre () {
        // TODO - Implementar metodo
        setNombre("Botella " + estado.toString());
    }

    public Elemento getContenido() {
        return contenido;
    }

    public void setContenido(Elemento contenido) {
        this.contenido = contenido;
    }

    public EstadoContenedor getEstado () {
        return estado;
    }

}