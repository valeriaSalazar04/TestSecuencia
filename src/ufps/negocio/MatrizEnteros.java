/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufps.negocio;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import ufps.util.ExceptionUFPS;
import ufps.util.Secuencia;
/**
 *
 * @author ValeriaS.!
 */
public class MatrizEnteros {
    
    private Secuencia<VectorUFPS> matriz;
    

    public MatrizEnteros() {
    }

    
    public MatrizEnteros(int filas , int columnas) throws ExceptionUFPS {
       this. matriz= new Secuencia<>(filas);
       if (columnas==0){
           
           crearElementosDispersos();
       }
       else{
          crearElementos(columnas);
       }
      
    }
    
    
    private void crearElementosDispersos() throws ExceptionUFPS
    {
        String msg="";
        for (int i=0;i<matriz.getLength();i++){
            int r=(int)(Math.random()*+1);
            msg=crearElementosVector(r);
            matriz.set(i, new VectorUFPS(msg));
        }
      
    }
    
    
    
    private void crearElementos(int columnas)throws ExceptionUFPS
    {
       String msg="";
      
        for (int i=0; i<matriz.getLength();i++){
            
            msg=crearElementosVector(columnas);
            matriz.set(i, new VectorUFPS(msg));
        }
            
        
        
    }
    
    
    private String crearElementosVector(int columnas )
    {
        
        String msg="";
        for (int i=0;i<columnas;i++){
            int r=(int)(Math.random()*10);
            msg+=r+";";
            
        }
        return msg;
        
    }
    
    
    
    //foreach o iterador
    public String toString()
    {
    String msg="";
    for (int i=0;i<matriz.getLength();i++){
     
         msg+= matriz.get(i).vector.toString();
           
     }
    
        
     return (msg);
    }
    
    
    
    
    
    /*
     * @return true si la matriz es dispersa o false en caso contrario
     */
    public boolean esDispersa(){
        
            int i=0;
            int aux=matriz.get(i).vector.length;
            int aux2=0;
            
            for(i=i+1; i<matriz.getLength();i++){
                aux2=matriz.get(i).vector.length;
                if (aux!=aux2){
                    return true;
                }
            }
            
                return false;
            }
    
    public boolean comparar (MatrizEnteros m){
        
        for (int i =0; i<matriz.getLength();i++){
            if (matriz.get(i).vector.length!=m.matriz.getLength()){
                return false;
            }
               if (!(matriz.get(i).equals(m.matriz.get(i))))
                return false;
            }
        
         return true;
        }
      

       
    
    
    /**
     * Compara si dos objetos de la clase MatrizEnteros son iguales
     * @param obj la matriz2 a comparar
     * @return 
     */
    public boolean equals(Object obj){
        MatrizEnteros m2=(MatrizEnteros)obj;
        boolean b= m2.esDispersa();
        if (this.esDispersa()&& b){
           
            if (this.comparar(m2)==true){
                return true;
            }
        }
        
        
        return false;
    }
    
    

}
