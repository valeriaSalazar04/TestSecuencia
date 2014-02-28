package ufps.util;
import java.util.Iterator;
/**
 * Clase para el manejo de Iteradores en una Lista Circular Doble Enlazada<T> con nodo cabecera
 * @author Marco Adarme
 * @version 2.0
 */
public class IteratorLCD<T> implements Iterator<T>
{
	
	private NodoD<T> cab, posicion;
	
        /**
         * Constructor con parametros de la clase
         * @param cab es de tipo Nodo<T> que contiene el nodo cabeza de la lista
         */
	IteratorLCD(NodoD<T> cab) {
            
            this.cab=cab;
            this.posicion=this.cab.getSig();
            
	}
        
        /**
         * remueve un dato de la lista
         */
        @Override
        public void remove()
        {}
	
        /**
         * Método que informa si existe otro elemento en la lista para seguir iterando
         * @return un tipo boolean que informa si existe o no un dato en la lista, desde la posición 
         * actual del cursor.
         */
        @Override
	public boolean hasNext() {
            
		return (this.posicion!=this.cab);
                
	}
	
        /**
         * Método que retorna un dato de la posición actual del cursor del iterador.
         * El cursor queda en la siguiente posición.
         * @return un tipo T que contiene el dato actual
         */
        @Override
	public T next() {
            
            if(!this.hasNext())
                return (null);
            
            this.posicion=this.posicion.getSig();
            
            return(this.posicion.getAnt().getInfo());
            
	}
	
}//Fin de la Clase