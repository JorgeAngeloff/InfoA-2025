/**
 * Representa una semana de das laborables
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class Semana
{
    // Representa la Semana como un conjunto de d�as de Lunes a Viernes
    public static final int DIAS_AGENDABLES_POR_SEMANA = 5;
    
    // Un n�mero de semana dentro de un a�o (0-52).
    private final int semanaNumero;
    private final Dia[] dias;

    /**
     * Constructor de objetos de la clase Semana.
     * @param semanaNumero El numero de la semana (0-52).
     */
    public Semana(int semanaNumero)
    {
        this.semanaNumero = semanaNumero;
        dias = new Dia[DIAS_AGENDABLES_POR_SEMANA];
        int diaEnAnio = semanaNumero * 7 + 1;
        for(int dia = 0; dia < DIAS_AGENDABLES_POR_SEMANA; dia++) {
            dias[dia] = new Dia(diaEnAnio);
            diaEnAnio++;
        }
    }

    /**
     * Imprime una lista de citas para esta semana
     */
    public void mostrarCitas()
    {
        System.out.println("*** Semana " + semanaNumero + " ***");
        for(Dia dia : dias) {
            dia.mostrarCitas();
        }
    }

    /**
     * @param diaEnSemana qu� d�a (1..DIAS_AGENDABLES_POR_SEMANA).
     * @return El Dia representando el n�mer do d�a, o null si diaEnSemana
     *         est� fuera de rango
     */
    public Dia getDia(int diaEnSemana)
    {
        if(diaEnSemana >= 1 && diaEnSemana <= DIAS_AGENDABLES_POR_SEMANA) {
            return dias[diaEnSemana - 1];
        }
        else {
            return null;
        }
    }

    /**
     * @return El numero de semana (0-52).
     */
    public int getSemanaNumero()
    {
        return semanaNumero;
    }
}
