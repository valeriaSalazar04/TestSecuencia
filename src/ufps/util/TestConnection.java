/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.util;
import java.sql.*; 


/**
 *Clase de prueba para realizar una conexión a una base de datos
 * @author madarme
 */
public class TestConnection {




 public static void main(String[] args) throws Exception 
 {
   BaseDeDatos.conectar();
    if (BaseDeDatos.hayConexion())
        System.out.println("...Hay conexión...");
    else
        System.out.println("...No Hay conexión...");

 }
}