package ufps.util;

/**
 * Clase que contiene la informacion de los nodos de una lista doble
 * @author Marco Adarme
 * @version 2.0
 * @param <T>
 */
class NodoD<T> implements java.io.Serializable
{
    
    private T info;
    private NodoD<T> ant;
    private NodoD<T> sig;

    
    /**
     * Crea un nodo vacío
     */
    public NodoD() {
    }
    
    
    
    /**
     * Constructur con parametros de la clase NodoD 
     * @param info de tipo T y contiene la informacion del nodo
     * @param sig es del tipo NodoD<T> y contiene la direccion del Nodo siguiente
     * @param ant es de tipo NodoD<T> y contiene la direccion del Nodo anterior
     */
    NodoD(T info, NodoD<T> sig, NodoD<T> ant) {
        
        this.info=info;
        this.sig=sig;
        this.ant=ant;
        
    }
    
    /**
     * Cambia la informacion contenida en el Nodo
     * @param info es de tipo T y contiene la informacion nueva del nodo
     */
    void setInfo(T info) {
        
            this.info = info;
            
    }
    
    /**
     * Obtiene el contenido del Nodo
     * @return un tipo T que contiene la informacion del Nodo
     */
    T getInfo() {
        
        return(this.info);
        
    }
    
    /**
     * Devuelve el nodo siguiente al que apunta el Nodo
     * @return un tipo NodoD<T> que contiene el nodo siguiente
     */
    NodoD<T> getSig() {
        
        return (this.sig);
        
    }
    
    /**
     * Cambia el nodo siguiente de nuestro Nodo
     * @param sig es de tipo NodoD<T> y contien la informacion del nuevo nodo siguiente
     */
    void setSig(NodoD<T> sig) {
        
        this.sig=sig;	
        
    }
    
    /**
     * Obtiene la dirección del Nodo anterior al actual
     * @return un Nodo<T> que contiene 
     */
    NodoD<T> getAnt() {
        
        return (this.ant);
        
    }
    
    /**
     * Cambia la dirección del nodo anterior por una nueva
     * @param ant es de tipo NodoD<T> y contiene la nueva dirección del nodo anterior
     */
    void setAnt(NodoD<T> ant) {
        
        this.ant=ant;
        
    }
    
}//Fin de la Clase