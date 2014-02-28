package ufps.util;

/**
 * Clase para el manejo de una Cola
 * @author Marco Adarme
 * @version 2.0
 */
public class Cola<T> {
    
    private ListaCD<T> miLista=new ListaCD<T>();
    
    /**
     * Constructor vacio de la clase
     */
    public Cola() {
    }
    
    /**
     * Agrega un elemento a la cola
     * @param info es de tipo T y contiene la informacion a en colar
     */
    public void enColar(T info)
    {
        this.miLista.addFin(info);
    }
    
    /**
     * Retira un elemento de la cola
     * @return un tipo T que contiene la informacion del nodo retirado
     */
    public T deColar()
    {
        return(this.miLista.remove(0));
    }
    
    /**
     * Método que retorna el tamaño de la cola
     * @return un tipo integer qeu contiene el tamaño de la cola
     */
    public int getSize()
    {
        return(this.miLista.getSize());
    }
   
    /**
     * Método que retorna si la cola esta vacia o no
     * @return un tipo boolean, true si es vacio y false si contiene nodos
     */
    public boolean esVacio()
    {
    	return (this.miLista.esVacio());
    }
    
}
