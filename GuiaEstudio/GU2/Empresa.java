public class Empresa {
    // Atributos
    private String cuit; // Sin guiones
    private String designacion;

    // Constructor
    public Empresa(String cuit, String designacion) {
        this.designacion = designacion;
        if (esCuitValido(cuit)) {
            this.cuit = cuit;
        } else {
            this.cuit = "";
        }
    }

    /**
     * Verifica el dígito verificador del CUIT.
     * Si es válido, lo asigna y devuelve true.
     * Si no, lo borra y devuelve false.
     */
    public boolean setCuit(String cuit) {
        if (esCuitValido(cuit)) {
            this.cuit = cuit;
            return true;
        } else {
            this.cuit = "";
            return false;
        }
    }

    /**
     * Método privado para validar un CUIT con el algoritmo Módulo 11.
     */
    private boolean esCuitValido(String cuit) {
        int[] serie = {2, 3, 4, 5, 6, 7};
        int suma = 0;

        // Recorrer los primeros 10 dígitos de derecha a izquierda
       for (int i = 0; i < 10; i++) {
         char c = cuit.charAt(9 - i);         // Tomamos el dígito desde el final hacia el principio
         int digito = c - '0';                // Convertimos el caracter a número entero
         int peso = serie[i % 6];             // Repetimos la serie 2,3,4,5,6,7
         suma += digito * peso;               // Sumamos el producto al total
}


        int resto = suma % 11;
        int esperado = 11 - resto;

        if (esperado == 11) {
            esperado = 0;
        } else if (esperado == 10) {
            return false; // CUIT inválido si da 10
        }

        int verificador = Integer.parseInt(cuit.substring(10, 11));
        return verificador == esperado;
    }

    /**
     * Retorna el valor del CUIT (puede ser "" si no fue válido).
     */
    public String getCuit() {
        return this.cuit;
    }

    /**
     * Asigna la designación.
     */
    public void setDesignacion(String designacion) {
        this.designacion = designacion;
    }

    /**
     * Retorna la designación.
     */
    public String getDesignacion() {
        return this.designacion;
    }
}

