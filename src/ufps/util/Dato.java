package ufps.util;
/**
 * Clase que permite tener objetos por referencias dentro de otra clase.
 * Simula el paso por referencia. 
 * @author Marco Adarme
 * @version 2.0
 */
public class Dato<T>
{
	private T info;
	
        /**
         * constructor con parametros de la clase
         * @param info contiene la informacion del dato
         */
	Dato(T info) {
            
            this.info=info;
            
        }
        
        /**
         * Método que devuelve la informacion del dato
         * @return un tipo T que contiene la información dee dato
         */
	public T getInfo() {
            
            return(this.info);
            
	}
        
        /**
         * Método que modifica el contenido del dato
         * @param info es de tipo T y contiene la informacion nueva del dato
         */
        public void setInfo(T info) {
            
            this.info=info;
            
        }        
}//Fin de la Clase