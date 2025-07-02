import java.util.HashMap;

public class Catalogo {
private HashMap<Madera,Integer> catalogo;

    /**
     *  Inicializa un HashMap para almacenar todas las maderas del enumerado
     *  y sus precios. Debe asignar precio por defecto 100
     **/
    public Catalogo (){
        catalogo=new HashMap<>();
        
        catalogo.put(Madera.ROBLE,100);
        catalogo.put(Madera.CAOBA,100);
        catalogo.put(Madera.NOGAL,100);
        catalogo.put(Madera.CEREZO,100);
        catalogo.put(Madera.PINO,100);
        
    }
    /**
     *  Ajusta el precio de una madera en particular
     **/
    public void setPrecio (Madera m,int precio){
        catalogo.put(m,precio);// No olvide comentar esta linea
    }
    /**
     *  Retorna el precio de una madera en particular
     **/
    public int getPrecio(Madera m){
        return catalogo.get(m); // No olvide comentar esta linea
    }

    /**
     *  Retorna el HashMap Catalogo
     **/
    public HashMap<Madera,Integer> getCatalogo(){
        return catalogo; // No olvide comentar esta linea
    }
}

