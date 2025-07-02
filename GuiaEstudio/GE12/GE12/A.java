public class A {
    private int valor;
    
    public A() {
        valor = 0;
    }
    
 /* 
  * Incrementa el campo valor sumando el valor de a.
  *
  * @param a La cantidad que en que se incrementa valor.
  * @throws IllegalArgumentException Si a es null o no es un entero.
  */
    public void incrementar(Integer a){
        //TODO implementar metodo
        if(a==null)
        {
        throw new IllegalArgumentException("Argumento nulo en incrementar(a)");
        
        
        }
        valor+=a;
    }

 /* 
  * Devuelve el valor de a.
  *
  * @return el valor de a.
  */
    public int getA(){
        return valor;
    }

}