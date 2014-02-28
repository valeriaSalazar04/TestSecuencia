/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.gui;
import ufps.negocio.MatrizEnteros;
import ufps.negocio.VectorUFPS;
import ufps.util.*;

/**
 *
 * @author MADARME
 */
public class TestSecuencia {
    
    public static void main(String nada[]) throws ExceptionUFPS
    {
     
        MatrizEnteros m= new MatrizEnteros(23, 7);
        System.out.println(m.toString());
//    Secuencia<Integer> m=new Secuencia<Integer>(4);
//    for(int i=0;i<m.getLength();i++)
//    {
//        m.set(i, i*10);
//    }
//    System.out.println(m.toString());
//    String algo="";
//    Secuencia<VectorUFPS> v=new Secuencia<VectorUFPS>(3);
//    for(int i=0;i<v.getLength();i++)
//    {
//        algo+=","+i;
//        v.set(i, new VectorUFPS("34,56,54"+algo));
//    }
//    
//    System.out.println(v.toString());
//    
//    }
//    
}
}
