/*
 * ExceptionUFPS.java
 *
 * Created on 6 de septiembre de 2008, 08:35 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ufps.util;

/**
 * Clase para la manipulación de excepciones propias, su manejo se realiza a través de la clase
 * <br/><b>Exception</b>
 * @author Marco Adarme
 * @version 2.0
 */
public class ExceptionUFPS extends Exception{
    
    /**
     * Constructor con parametros de la clase
     * @param mensajeDeError es de tipo String y contiene el mensaje de error para mostrar
     */
    public ExceptionUFPS(String mensajeDeError) {
        
        super(mensajeDeError);
        
    }
    
}//Fin de la Clase
