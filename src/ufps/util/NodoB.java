package ufps.util;

/**
 * Clase que contiene la informacion de los nodos de cada arbol
 * @author Marco Adarme
 * @version 2.0
 */
public class NodoB<T>
{
    
    private T info;
    private NodoB<T> izq, der;
    
    /**
     * Contructor vacio de la clase
     */
    public NodoB() {
    }
    
    /**
     * Constructor con parametros de la clase
     * @param x es de tipo T el cual posee la información del nodo del arbol
     * @param i es de tipo Nodo<T> el cual posee el nodo del lado izquierdo
     * @param d es de tipo Nodo<T> el cual posee el nodo del lado derecho
     */
    public NodoB(T x, NodoB<T> i, NodoB<T> d) {
        
        this.info=x;
        this.izq=i;
        this.der=d;
        
    }
    
    /**
     * Contructor con parametros de la clase que genera una hoja del arbol
     * @param x 
     */
    public NodoB(T x) {
        
        this.info=x;
        this.izq=this.der=null;
        
    }
    
    /**
     * Método que retona la información del nodo
     * @return un tipo T que contiene la información del nodo
     */
    public T getInfo() {
        
        return this.info;
        
    }
    
    /**
     * Método el cual retona el nodo izquierdo
     * @return un tipo Nodo<T> el cual contiene el nodo izquierdo
     */
    
    public NodoB<T> getIzq() {
        
        return this.izq;
        
    }
    
    /**
     * Método el cual retona el nodo derecho
     * @return un tipo Nodo <T> el cual contiene el nodo derecho
     */
    public NodoB<T> getDer() {
        
        return this.der;
        
    }
    
    /**
     * Método que modifica el nodo izquierdo
     * @param i es de tipo NodoB<T> que contiene el nodo izquierdo
     */
    public void setIzq(NodoB<T> i) {
        
        this.izq=i;
        
    }
    
    /**
     * Método que modifica el nodo derecho
     * @param d es de tipo NodoN<T> que contiene el nodo derecho
     */
    
    public void setDer(NodoB<T> d) {
        
        this.der=d;
        
    }
    
    /**
     * Método que modifica el contenido del nodo
     * @param d de tipo T y contiene la información del nodo
     */
    public void setInfo(T d) {
        
        this.info=d;
        
    }
}//Fin de la Clase
