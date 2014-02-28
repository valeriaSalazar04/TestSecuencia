/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.util;

/**
 *
 * @author MADARME
 */
public class Secuencia<T> {
    
    private T vector[];

    public Secuencia() {
    }

    public Secuencia(int cantidad) {
        if(cantidad<=0)
        {
            throw new RuntimeException("Cantidad <=0");
        }
        
        //computer sciences-->this.vector=new T[cantidad];
        Object trampa[]=new Object[cantidad];
        this.vector =(T[])trampa;
    }

    
    
    public int getLength()
    {
        return (this.vector.length);
    }
    
    
    public T get(int i)
    {
        if(i<0 || i>=this.getLength()|| this.vector==null )
        {
        throw new RuntimeException("Fuera de rango los índices");
        }
        return(this.vector[i]);
    }
    
    public void set(int i, T info)
    {
        if(i<0 || i>=this.getLength()|| this.vector==null )
        {
        throw new RuntimeException("Fuera de rango los índices");
        }
       this.vector[i]=info;
    }
    
    
     public String toString()
    {
    String msg="";
    for(T dato:this.vector)
        {
            msg+=dato.toString()+"\t";
        }
    return (msg+"\n");
    }
    
    
    
    public boolean equals(Object obj)
    {
     Secuencia  v2=(Secuencia)obj;
    if(this.vector.length!=v2.vector.length)
    {
        return false;
    }
    
    for(int i=0;i<this.vector.length;i++)
    {
        if(!(this.vector[i].equals(v2.vector[i])))
        {
            return false;
        }
        
    } 
     return true;
    }   
     
    
    
    
    
    
    public T[] getVector() {
        return vector;
    }

    public void setVector(T[] vector) {
        this.vector = vector;
    }
    
    
    
    
}
