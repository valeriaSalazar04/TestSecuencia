
 package ufps.util;
 
 /**
 * Clase que contiene la informacion de los nodos de cada lista
 * @author Marco Adarme
 * @version 2.0
 */
class Nodo<T> implements java.io.Serializable
{
    private T info;
    private Nodo<T> sig;
	
    /**
     * Contructor vacío . Inicializa el campo info  y el campo siguiente en 
     * null
     */
    Nodo() {
        
        this.info=null;
        this.sig=null;
        
    }
	
    /**
     * Contructor inicializa los miembros datos de Nodo
     * @param info Objeto de tipo T
     * @param sig Siguiente Nodo
     */
    Nodo(T info, Nodo<T> sig) {
        
        this.info=info;
        this.sig=sig;
        
    }
	
    /**
     * Obtiene la información del nodo
     * @return Un objeto tipo T
     */
    T getInfo() {
        
        return this.info;
        
    }
	
    /**
     * Obtiene el Nodo Siguiente
     * @return El nodo siguiente o null si el último nodo o si es una Lista
     * con cardinalidad 1
     */
    Nodo<T> getSig() {
        
        return this.sig;
        
    }
	
    /**
     * Cambia la informaci�n del Nodo del campo Info
     * @param nuevo Nuevo objeto que desea almacenarse en el Nodo
     */
    void setInfo(T nuevo) {
        
        this.info=nuevo;
        
    }
	
    /**
     * Cambia el nodo siguiente
     * @param nuevo Nuevo Nodo Siguiente
     */
    void setSig(Nodo<T> nuevo) {
        
        this.sig=nuevo;
        
    }
}//Fin de la Clase