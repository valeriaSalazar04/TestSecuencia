 
 package ufps.util;
 import java.util.Iterator;
 /**
 * Clase Para el manejo de una Lista Circular Doble Enlazada<T>
 * @author Marco Adarme
 * @version 2.0
 */
public class ListaCD<T> implements Iterable<T>
{

    private NodoD<T> cab;
    private int size=0;
    
    
    /**
     * Constructor de la Clase Lista Circular Doble Enlazada, Crea
     * un nodo que sirve como cabecera de la ListaCD<T>
     */
    
    public ListaCD() {
        
        this.cab=new NodoD<T> (null,null,null);
        this.cab.setSig(cab);
        cab.setAnt(cab);        
        
    }//fin constructor
	
    /**
     * Adiciona un Elemento al Inicio de la Lista
     * @param dato Informacion que desea almacenar en la Lista. La informacion
     * debe ser un Objeto.
     */
    public void addInicio(T dato){
        
        NodoD<T> x=new NodoD<T> (dato, cab.getSig(), cab);
        
        cab.setSig(x);
        
        x.getSig().setAnt(x);
        
        this.size++;
        
    }//fin addInicio
	
	
    /**
     * Inserta un Elemento al Final de la Lista
     * @param dato Informacion que desea almacenar en la Lista. La informacipon
     * debe ser un Objeto.
     */
	
	public void addFin(T dato){
            
            
	    NodoD<T>x=new NodoD<T>(dato, cab, cab.getAnt());
            
	    cab.getAnt().setSig(x);
	    cab.setAnt(x);
            
	    this.size++;
            
	}//fin addFin
	
	
    /**
     * Borra un elemento de la lista dada una posicion
     * @param i Posicion del objeto
     *@return el objeto que se borro 
     */

        public T remove(int i){
            
            try{
                
                NodoD<T> x=this.getPos(i);
               
                x.getSig().setAnt(x.getAnt());
                x.getAnt().setSig(x.getSig());
                x.setSig(null);
                x.setAnt(null);
                
                this.size--;
                
                return(x.getInfo());
                
            }catch(ExceptionUFPS ex) {
                
            System.err.println(ex.getMessage());
            
            }
            
	return(null);	    	    
        
	}//fin remove
	
    /**
     * Retorna el Objeto de la posicion i
     * @param i posicion de un elemento de la lista
     * @return Devuelve el Objeto de la posicion especificada , null en caso contrario
     */	
    public T get(int i){
        
        try {
            
                NodoD<T> x=this.getPos(i);
                return(x.getInfo());
                
            }catch (ExceptionUFPS ex) {
                
                System.err.println(ex.getMessage());
                
            }
        
            return (null);
            
        }
        
	/**
         * funcion de tipo private retorna un nodo con la posicion de este en la
         * lista y ejecuta una exception si sucede un error
         * @param i es de tipo integer y contiene la posicion del elemento en la lista
         * @return un tipo NodoD<T> con el nodo de la posicion
         */
	private NodoD<T> getPos(int i)throws ExceptionUFPS{
            
	    if(i<0||i>=this.size)
	       throw new ExceptionUFPS("Error indice no valido en una Lista Circular Doblemente Enlazada");
            
	    NodoD<T> x=cab.getSig();
            
	    for( ; i-->0; x=x.getSig());
            
	    return x;
            
	}//fin pos
	    
    /**
     * Borra la ListaCD<T>
     * 
     */
    public void removeAll(){
        
        this.cab.setSig(cab);
        this.cab.setAnt(cab);
        this.size=0;
        
    }//fin removeAll
    
    
    /**
     * Retorna true si la lista esta vacia, false en caso contrario
     * @return un boolean
     */
    public boolean esVacio(){
        
        return(cab==cab.getAnt());
        
    }//fin esVacio

    /**
     * Devuelve el tamaño de la lista
     * @return un int con el tamaño de la lista
     */
    
    public int getSize()
    {
        return (this.size);
        
    }
    	

    /**
     * Busca un elemento de la lista y devuelve su posicion.Los objetos
     * que se almacenan en la lista deben tener el Método equals.
     * @return un entero que representa una posicion en la lista
     */
    public int indexOf(T dato)    
    {
    	
    	int i=0;
        
    	for(NodoD<T> x=this.cab.getSig();x!=this.cab;x=x.getSig())
    	{
            if(x.getInfo().equals(dato))
                return(i);
            
            i++;
            
        }
    	
    	return (-1);
    }
        
  /**
  * Obtiene Iterador para una Lista Doble
  * @return IteratorLCD<T>
   */	      
   public Iterator<T> iterator()
   {
   	return (new IteratorLCD<T>(this.cab));
   }
        
    /**
     * Adiciona un Objeto en forma Ordenada, la
     *  clase debe tener el m�todo compareTo
     * @param info Objeto que se desea insertar en la Lista
     */
   
   public void addOrdenado(T info) {
       
       Comparable x=(Comparable) info;
     
       
       if(this.esVacio()|| x.compareTo(this.cab.getSig().getInfo())<=0) {
           
          this.addInicio(info);
		}
		
		else
		{
                    NodoD<T> nuevo=new NodoD<T>(info, null, null);
                    NodoD<T> p=this.cab.getSig();
                
                    for( ; p.getSig()!= this.cab && x.compareTo(p.getInfo()) >= 0; p = p.getSig());
                
                    if(p.getSig()== this.cab && x.compareTo(p.getInfo()) >= 0)
                    {
                        this.addFin(info);
                    }
                    else {
                        
                        nuevo.setAnt(p.getAnt());
                        nuevo.setSig(p);
                        p.setAnt(nuevo);
                        nuevo.getAnt().setSig(nuevo);
                        this.size++;
                        
                    }
                
                
                }
	
	}
        
        /**
         * Concadena dos listas, la segunda en la primera
         * @param lista1 es la lista en la que se va a concatenar la sengunda lista
         * @param lista2 es la lista que sera concatenada en la primera 
         * @return un boolean, si es true concateno las listas y si es 
         * false no.
         */
        
        public boolean concat(ListaCD lista2){
            
            if(!this.esVacio()){
                
                for(IteratorLCD<T> l= (IteratorLCD<T>) lista2.iterator(); l.hasNext(); )
                    this.addFin(l.next());
                
            }else return false;
            
            return true;
        }
        
      /**
     * modifica el elemento que se encuentre en una posici�n dada
     * @param i Una Posici�n dentro de la Lista
     * @param dato es el nuevo valor que toma el elmento en la lista
     */
        
    public void set(int i, T dato){
        
        try{
		NodoD<T> t=this.getPos(i);                
		 t.setInfo(dato);
                
        }catch(ExceptionUFPS e)
        {
            System.err.println(e.getMessage());
        }
    }
    /**
     * convierte una lista circular doble en un array tipo T[]
     * @return un Array de tipos Objects donde se encuentra la lista convertida
     */
    public T[] toArray()
    {
         if(this.esVacio())
                return (null);
         
        Object vector[]=new Object[this.size];
        
        Iterator<T> it=this.iterator();
        
        int i=0;
        
        while(it.hasNext())
            vector[i++]=it.next();
        return((T[])vector);
        }
    
/**
     * Devuelve un String con toda la informaci�n de los elementos
     * de la Lista. Recomendaci�n: La clase que se almacena en la Lista
     * debe tener sobreescrito el m�todo toString()
     * @return Un String con los datos de los elementos de la Lista
     */
	public String toString()
	{
            
		String r="";
                
		for(NodoD<T> x=this.cab.getSig();x.getInfo()!=null;x=x.getSig())
                    r+=x.getInfo().toString()+"-";
                
		return(r);
                
	}
        
         /**
         * busca un elemento en la lista si lo encuentra retorna true, de lo contrario false
         * @param info el cual contiene el valor del parametro a buscar en la lista
         * @return un boolean, si es true encontro el dato en la lista y si es 
         * false no.
         */
        public boolean containTo(T info)
        {
            return (this.indexOf(info)!=-1);
        }
}//fin class