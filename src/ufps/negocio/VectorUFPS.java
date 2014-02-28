/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.negocio;
import ufps.util.ExceptionUFPS;

/**
 *
 * @author MADARME
 */
public class VectorUFPS {
    
    int vector[];
    
    public VectorUFPS()
    {}
    
    public VectorUFPS(String cadena) throws ExceptionUFPS
    {
        if (cadena.isEmpty()){
        
         System.out.println("ta vacia brutos");
        
        }
       else{
            System.out.println("holaaa brutos");
        String vect[]=cadena.split(",");
         for ( int i = 0 ; i<vect.length;i++)  {
        System.out.println(vect[i]+"\n");
          this.vector=new int[vect.length];
        crear(vect);
            
         }
    }
        
        
       
    }
    private void crear(String x[]) throws ExceptionUFPS
    {
        
        for(int i=0;i<x.length;i++)
        {
            try{
                this.vector[i]=Integer.parseInt(x[i]);
            }catch(java.lang.NumberFormatException e)
            {
                throw new ExceptionUFPS("Un dato de la cadena tiene alfanumérico");
            }
        }
        
    }
    
    
    public String toString()
    {
    String msg="";
    for(int dato:this.vector)
        {
            msg+=dato+"\t";
        }
    return (msg+"\n");
    }
    
    public boolean equals(Object obj)
    {
    VectorUFPS v2=(VectorUFPS)obj;
    if(this.vector.length!=v2.vector.length)
    {
        return false;
    }
    
    for(int i=0;i<this.vector.length;i++)
    {
        if(this.vector[i]!=v2.vector[i])
        {
            return false;
        }
    }
    
    return true;
    
    }
    
    
            
    
}
