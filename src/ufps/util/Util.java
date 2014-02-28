/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.util;

/**
 *
 * @author MADARME
 */
public class Util{
    
    public static <T> void imprimir(T obj)
    {
       System.out.println(obj.toString());
    }
    
    public static <T> void sonIguales(T obj1, T obj2)
    {
        System.out.println(obj1.getClass().getName());
        if(obj1.equals(obj2))
        {
                 System.out.println("Son iguales :)");
        }
        else
        {
                 System.err.println("No son iguales :(");
        }
    }
    
}
