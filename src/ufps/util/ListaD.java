 package ufps.util;
 import java.util.Iterator;
 /**
 * Clase Para el manejo de una Lista Doble Enlazada<T>
 * @author Marco Adarme
 * @version 2.0
 */
public class ListaD<T> implements Iterable<T>
{
	
	private NodoD<T> cab;
	private int size;
	
	
    /**
     * Constructor de la Clase Lista Doble Enlazada, por defecto Inicializa
     * la cabeza de la lista en null.
     */
	public ListaD()
        {
            this.cab=null;
            this.size=0;
	}
		
		
	
    /**
     * Adiciona un Elemento al Inicio de la Lista
     * @param x Informaci�n que desea almacenar en la Lista. La informaci�n
     * debe ser un Objeto.
     */
	public void addInicio(T x)
        {
            if (this.cab==null)
                this.cab=new NodoD<T>(x,null,null);
            else{
                
                this.cab=new NodoD<T>(x, this.cab, null);
                this.cab.getSig().setAnt(this.cab);
            }
            
            this.size++;
			
        }
		
    /**
     * Inserta un Elemento al Final de la Lista
     * @param x Informaci�n que desea almacenar en la Lista. La informacipon
     * debe ser un Objeto.
     */
	public void addFin(T x)
	{
            if(this.cab==null)
                this.addInicio(x);
            else{
                
                NodoD<T> ult;
                
                try {
                    
                    ult = this.getPos(this.size - 1);
                    ult.setSig(new NodoD<T>(x, null, ult));
                    this.size++;
                } catch (ExceptionUFPS ex) {
                    
                    System.err.println(ex.getMessage());
                    
                }
                
            }
		
	}
	
	/*
         * retorna true si la lista es vacia
         * @return un boolean que es true si esta vacia la lista y false sino
         */
	public boolean esVacio()
	{
			
            return(this.cab==null);
            
	}
        
	/*
         * Funcion que remueve un elemento de la lista con la posicion de esta en la lista
         * @param i es un tipo integer que contiene la posicion del elemento en la lista
         * @return un tipo T que contiene el elemento removido de la lista
         */
	public T remove(int i)
	{
            try {
                
                NodoD<T> x;
                
                x = this.getPos(i);
                
                if(x==this.cab)
		{
                    //MOVER LA cab
                    this.cab=this.cab.getSig();
                    //REFERENCIAS DE NODO X A NULL
		}
                else {
                    x.getAnt().setSig(x.getSig());
                    if(x.getSig()!=null)//SI NO ES EL ULTIMO NODO
                        x.getSig().setAnt(x.getAnt());
                    }
                
		//LIBERO A NODO X
                
		x.setAnt(null);
		x.setSig(null);
                
		this.size--;
                
		return(x.getInfo());
                
            }catch (ExceptionUFPS ex) {
                System.err.println(ex.getMessage());
              }
            
	return(null);
        
	}
	
	/*
         * Borra la Lista Doble
         */
	public void removeAll()
	{
            this.cab=null;
            this.size=0;
        }
	
        /*
         * obtiene el contenido de un nodo en la lista
         * @param i es de tipo integer y contiene la posicion del nodo en la lista
         * @return T que contiene la informacion en el nodo de la lista
         */
        public T get(int i)
	{
            NodoD<T> t;
            
            try {
                
                t = this.getPos(i);
                
        	return (t.getInfo());    
                
            } catch (ExceptionUFPS ex) {
                
                System.err.println(ex.getMessage());
            }
            
	return (null);
        
	}
	
        /*
         * retorna el tamaño de la lista
         * @return un tipo integer que contiene el tamaño del a lista
         */
	public int getSize()
        {
            return this.size;
            
        }
	
	/*
         * funcion de tipo private retorna un nodo con la posicion de este en la
         * lista y ejecuta una exception si sucede un error
         * @param i es de tipo integer y contiene la posicion del elemento en la lista
         * @return un tipo NodoD<T> con el nodo de la posicion
         */
	private NodoD<T> getPos(int i) throws ExceptionUFPS
	{
            if(i>this.size || this.cab==null || i<0)
                throw new ExceptionUFPS("Error indice no valido en una Lista Doble Enlazada");
            
            NodoD<T> t=this.cab;
            
            while(i>0){
                
                i--;
		t=t.getSig();
                
            }
            
            return(t);
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
		for(NodoD<T> x=this.cab;x!=null;x=x.getSig())
		 r+=x.getInfo().toString()+"-";
		return(r);
	}
	
		
    /**
     * Obtiene la posici�n de un objeto en la Lista. Se recomienda
     * que la clase tenga sobre escrito el m�todo equals.
     * @param info Objeto que se desea buscar en la Lista
     * @return un int con la posici�n del elemento,-1 si el elemento no se 
     * encuentra en la Lista
     */
	public int indexOf(T info)
	{
            int i=0;
            
            for(NodoD<T> x=this.cab;x!=null;x=x.getSig())
            {
                
                if(x.getInfo().equals(info))
                    return (i);
                
                i++;
                
            }
		
            
            return (-1);
	}
	
    /**
     * Obtiene Iterador para una Lista Doble
     * @return IteratorLD<T>
     */	
    @Override
      public Iterator<T> iterator()
      {
          
          return(new IteratorLD<T>(this.cab));
          
      }
	
    /**
     * Adiciona un Objeto en forma Ordenada, la
     *  clase debe tener el m�todo compareTo
     * @param info Objeto que se desea insertar en la Lista
     */
	
	public void addOrdenado(T info)
	{ 
		Comparable x=(Comparable)(info);
		 
		if(this.esVacio()|| x.compareTo(this.cab.getInfo())<=0)
		{
                    System.out.println("La lista esta vacia");
                    this.addInicio(info);
		}else{
                    
                    NodoD<T> nuevo=new NodoD<T>(info, null, null);
                    NodoD<T> p=this.cab;
                    
                    for( ; p!= null && x.compareTo(p.getInfo()) >= 0; p = p.getSig());
                    
                    if(p==null)
			this.addFin(info);
                    else {
                        
                        nuevo.setAnt(p.getAnt());
			nuevo.setSig(p);
			p.setAnt(nuevo);
			nuevo.getAnt().setSig(nuevo);
			this.size++;
				
                    }
                    
                }
                
        }
        
        /*
         * convierte la lista a un tipo array
         * @return un tipo Object[] el cual es la lista convertida en un array
         */
        public Object[] toArray()
        {
            if(this.esVacio())
                return (null);
            
            Object vector[]=new Object[this.size];
            
            Iterator<T> it=this.iterator();
            
            int i=0;
            
            while(it.hasNext())
                vector[i++]=it.next();
            
            return(vector);
        }
        
        /*
         * Concadena dos listas, la segunda en la primera
         * @param lista1 es la lista en la que se va a concatenar la sengunda lista
         * @param lista2 es la lista que sera concatenada en la primera 
         * @return un boolean, si es true concateno las listas y si es 
         * false no.
         */
        
        public boolean concat(ListaD lista2){
            
            if(!this.esVacio()){
                
                for(IteratorLD<T> l= (IteratorLD<T>) lista2.iterator(); l.hasNext(); )
                    this.addFin(l.next());
                
            }else return false;
            
            return true;
        }
        
        /*
         * busca un elemento en la lista si lo encuentra retorna true, de lo contrario false
         * @param info el cual contiene el valor del parametro a buscar en la lista
         * @return un boolean, si es true encontro el dato en la lista y si es 
         * false no.
         */
        public boolean containTo(T info)
        {
            return (this.indexOf(info)!=-1);
        }
        
     /**
     * modifica el elemento que se encuentre en una posici�n dada
     * @param i Una Posici�n dentro de la Lista
     * @param dato es el nuevo valor que toma el elmento en la lista
     */
        
    public void set(int i, T dato){
        
        try{
		NodoD<T> t=this.getPos(i);                
		
                if (t==null)
		{
                    System.err.println("Posici�n:"+ i +",no existe o Lista Vac�a");
		}
                
                t.setInfo(dato);
                
        }catch(ExceptionUFPS e)
        {
            System.err.println(e.getMessage());
        }
    }
}//Fin de Clase