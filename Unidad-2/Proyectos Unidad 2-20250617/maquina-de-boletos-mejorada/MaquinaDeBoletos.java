/**
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class MaquinaDeBoletos
{
    // El precio de un boleto a partir de esta m�quina.
    private int precio;
    // La cantidad de dinero ingresada por el usuario hasta
    // el momento.
    private int saldo;
    // El total de dinero recolectado por �sta m�quina.
    private int total;

    /**na que suministra boletos de un precio dado..
     */
    public MaquinaDeBoletos(int precioDelBoleto)
    {
        precio = precioDelBoleto;
        saldo = 0;
        total = 0;
    }

    /**
     * Retorna el precio de un boleto.
     */
    public int getPrecio()
    {
        return precio;
    }

    /**
     * Retorna la cantidad de dinero ya insertada para el
     * siguiente boleto
     */
    public int getSaldo()
    {
        return saldo;
    }

    /**
     * Recibe del usuario una cantidad de dinero en centavos. 
     * Controla que la cantidad tenga sentido.
     */
 public void insertarDinero(int cantidad)
    {
        if(cantidad > 0) {
            saldo = saldo + cantidad;
        }
        else {
            System.out.println("Debe ingresar una cantidad positiva: " +
                               cantidad);
        }
    }

    /**
     * Imprime un boleto si la cantidad de dinero ingresada
     * alcanza y disminuye el saldo actual en el precio del
     * boleto. Imprime un mensaje de error si se requiere m�s
     * dinero.
     */
    public void imprimirBoleto()
    {
        if(saldo >= precio) {
           // Simulata la impresi�n de un boleto.
           System.out.println("##################");
           System.out.println("# La L�nea BlueJ");
           System.out.println("# Boleto");
           System.out.println("# " + precio + " cvos.");
           System.out.println("##################");
           System.out.println();

           // Actualizar el total recolectado con el saldo.
           total = total + saldo;
           // Reduce el saldo en el precio del boleto.
           saldo = saldo - precio;
        }
        else {
            System.out.println("Debe ingresar como m�nimo: " +
                               (precio - saldo) + " cvos. m�s.");
                    
        }
    }

    /**
     * Da el vuelto del dinero ingresado cuando es superior al precio
     * El saldo se pone a cero
     */
    public int reintegrarSaldo()
    {
        int cantidadAReintegrar;
        cantidadAReintegrar = saldo;
        saldo = 0;
        return cantidadAReintegrar;
    }
}
