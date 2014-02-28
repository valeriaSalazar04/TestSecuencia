package ufps.util;

/**
 * Clase para el manejo de una Pila 
 * @author Marco Adarme
 * @version 2.0
 */
public class Pila<T>
{
    
    private ListaCD<T> miLista;
    
    /**
     * Constructor vacio de la clase
     */
    public Pila() {
        
        this.miLista=new ListaCD<T>();
        
    }
    
    /**
     * Método que inserta un elemento en la pila
     * @param info es de tipo T y contiene la información a insertar en la pila
     */
    public void push(T info) {
        
        this.miLista.addInicio(info);
        
    }
    
    /**
     * Método que retira y devuelve un elemneto de la pila
     * @return un tipo T y contiene la información retirada de la pila
     */
    
    public T pop() {
        
        return (this.miLista.remove(0));
        
    }
    
    /**
     * Método que comprueba si la pila esta vacía
     * @return un tipo boolean, true si es vacía y false si no.
     */
    
    public boolean esVacio() {
        
        return(this.miLista.esVacio());
        
    }
    
    
    /**
     * Método que retorna el tamaño de la pila
     * @return un tipo integer qeu contiene el tamaño de la pila
     */
    public int getSize()
    {
        return (this.miLista.getSize());
    }
    
}//Fin de la Clase