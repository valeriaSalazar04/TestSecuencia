/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.gui;
import ufps.negocio.MatrizEnteros;
import ufps.negocio.VectorUFPS;
import ufps.util.ExceptionUFPS;

/**
 *
 * @author MADARME
 */
public class TestVector {
    
    public static void main(String nada[]) throws ExceptionUFPS
    {
        //VectorUFPS v=new VectorUFPS("45,56,67,234");
        
        {
        //error1
        //VectorUFPS v=new VectorUFPS(null);
        //error2
        //VectorUFPS v=new VectorUFPS("34,45,56c");
        //No hay errores:
        MatrizEnteros v=new MatrizEnteros(7,0);
        System.out.println(v.toString());
        }
    }
}
    