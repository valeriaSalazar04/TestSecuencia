
 package ufps.util;
 import java.util.Iterator;
 /**
 * Clase Para el manejo de una Lista Simple Enlazada<T>
 * @author Marco Adarme
 * @version 2.0
 */
public class ListaS<T> implements Iterable<T>
{
    private Nodo<T> cab;
    private int size;
	
    /**
     * Constructor de la Clase Lista Simple Enlazada, por defecto Inicializa
     * la cabeza de la lista en null.
     */
    public ListaS() {
        
        this.cab=null;
        this.size=0;
    
    }
	
    /**
     * Adiciona un Elemento al Inicio de la Lista
     * @param x Informaci�n que desea almacenar en la Lista. La informacipon
     * debe ser un Objeto.
     */
    public void addInicio(T x){
        
        this.cab=new Nodo<T>(x, this.cab);
        this.size++;
        
    }
	
    /**
     * Inserta un Elemento al Final de la Lista
     * @param x Información que desea almacenar en la Lista. La informacipon
     * debe ser un Objeto.
     */
    public void addFin(T x) {
        
        if(this.cab==null)
            this.addInicio(x);
        else {
            
            try {
                
                Nodo<T> ult=this.getPos(this.size-1);
                ult.setSig(new Nodo<T>(x, null));
                this.size++;
                
            }catch(ExceptionUFPS e) {
                
                System.err.println(e.getMessage());
                
            }
            
        }
        
    }
        
    /**
     * Ingresa un elemento ordenado en la lista
     * @param info elemento a ingresar
     */
    public void addOrdenado(T info) {
        
        if (this.esVacia())
            this.addInicio(info);
        
        else {
            
            Nodo<T> x=this.cab;
            Nodo<T> y=x;
            
                while(x!=null) {
                    
                    Comparable comparador=(Comparable)info;
                    int rta=comparador.compareTo(x.getInfo());
                    
                    if(rta<0)
                        break;
                    
                    y=x;
                    x=x.getSig();
                    
                }
                
            if(x==y)
                this.addInicio(info);
            else {
                
                y.setSig(new Nodo<T>(info, x));
                this.size++;
                
            }
            
        }
    
    }
        
    /**
     * Modifica el elemento que se encuentre en una posici�n dada
     * @param i Una Posición dentro de la Lista
     * @param dato es el nuevo valor que toma el elmento en la lista
     */        
    public void set(int i, T dato){
        
        try{
            
            Nodo<T> t=this.getPos(i);
            t.setInfo(dato);
            
        }catch(ExceptionUFPS e) {
            
            System.err.println(e.getMessage());
            
        }
        
    }    

    /**
     * Retorna el elemento que se encuentre en una posici�n dada
     * @param i Una Posición dentro de la Lista
     * @return El objeto que se encuentra en esa posición. El objeto
     * retorna su valor parametrizada "T". Si la posición no se
     * encuentra en la Lista retorna null.
     */
    public T get(int i) {
        
        try {
            
            Nodo<T> t=this.getPos(i);
            return (t.getInfo());
            
        }catch(ExceptionUFPS e) {
            
            System.err.println(e.getMessage());
            
        }
        
        return(null);
        
    }
    
    /**
     * Elemento privado de la clase que devuelve al elemento en la posicion
     * @param i Una posici�n en la Lista
     * @return El elemento encontrado. Si la posici�n no es v�lida
     * retorna null
     */
    private Nodo<T> getPos(int i) throws ExceptionUFPS {
        
        if(this.esVacia() || i>this.size  || i<0)
            throw new ExceptionUFPS("El indice solicitado no existe en la Lista Simple");
        
        Nodo<T> t=this.cab;
        
        while(i>0) {
            
            t=t.getSig();
            i--;
            
        }
        
        return(t);
        
    }
    
    /**
     * Borra un elemento dada una posición
     * @param i Una posición en la Lista
     * @return El elemento que borro. Si la posición no es válida
     * retorna null
     */
    public T remove(int i) {
        
        if(this.esVacia())
            return null;
        
        Nodo<T> t=this.cab;
        
        if(i==0)
            this.cab=this.cab.getSig();
        else {
            
            try {
                
                Nodo<T> y=this.getPos(i-1);
                t=y.getSig();
                y.setSig(t.getSig());
                
            }catch(ExceptionUFPS e) {
                
                System.err.println(e.getMessage());
                
            }
            
        }
        
        t.setSig(null);
        
        this.size--;
        
        return(t.getInfo());
        
    }
    
    /**
     * Borra la Lista Simple
     */
    public void removeAll(){
        
           this.cab=null; 
           this.size=0;
           
    }
	
    /**
     * Verifica si la Lista esta o no vac�a
     * @return true si la lista esta vac�o , false si no
     */
    public boolean esVacia() {
        
        return(this.cab==null);
        
    }
    
    /**
     * Invierte la Lista en ella misma
     */
    public void Invertir() {
        
        Nodo<T> a,p;
        a=p=null;
        
        while(this.cab!=null) {
            
            a=this.cab;
            this.cab=this.cab.getSig();
            a.setSig(p);
            p=a;
            
        }
        
        this.cab=a;
        
    }
		
    /**
     * Obtiene la cantidad de elementos de la Lista
     * @return int con el tamaño de la lista. Si la Lista
     * esta vacía retorna 0
     */
    public int getSize() {
        
        return (this.size);
        
    }
    
    /**
     * Devuelve un String con toda la informaci�n de los elementos
     * de la Lista. Recomendaci�n: La clase que se almacena en la Lista
     * debe tener sobreescrito el m�todo toString()
     * @return Un String con los datos de los elementos de la Lista
     */
    @Override
    public String toString() {
        
        if (this.esVacia())
            return ("Lista Vacia");
        
        String r="";
        
        for(Nodo<T> x=this.cab;x!=null;x=x.getSig())
            r+=x.getInfo().toString()+"->";
        
        return(r);
        
    }
    
    /**
     * Obtiene la posición de un objeto en la Lista. Se recomienda
     * que la clase tenga sobre escrito el método equals.
     * @param info Objeto que se desea buscar en la Lista
     * @return un int con la posición del elemento,-1 si el elemento no se 
     * encuentra en la Lista
     */
    public int indexOf(T info) {
        
        int i=0;
        
        for(Nodo<T> x=this.cab;x!=null;x=x.getSig()) {
            
            if(x.getInfo().equals(info))
                return (i);
            
            i++;
            
        }
        
        return (-1);
        
    }
	
     /**
     * Retorna la lista simple en un elemento Iterator 
     * @return Un iterator tipo <T> de la lista
     */
    @Override
    public Iterator<T> iterator() {
        
        return new IteratorLS<T>(this.cab);
        
    }
    
    /**
     * Retorna la lista simple en un array 
     * @return un Array Object  de la lista
     */
    public T[] toArray() {
        
        if(this.esVacia())
            return (null);
        Object vector[]=new Object[this.size];
        int i=0;
        Iterator<T> it=this.iterator();
        while(it.hasNext())
            vector[i++]=it.next();
        
        return((T[])vector);
        
    }
    
    /**
     * busca un elemento en la lista si lo encuentra retorna true, de lo contrario false
     * @param info el cual contiene el valor del parametro a buscar en la lista
     * @return un boolean, si es true encontro el dato en la lista y si es 
     * false no.
     */
    public boolean containTo(T info) {
        
        return (this.indexOf(info)!=-1);
        
    }
    
    /**
     * Concatena dos listas simples. La lista2 , se borra. 
     * @param lista1 es la lista en la que se va a concatenar la sengunda lista
     * @param lista2 es la lista que sera concatenada en la primera 
     * @return un boolean, si es true concateno las listas y si es 
     * false no.
     */
    public boolean concat(ListaS lista2) {
        
        if(!this.esVacia()) {
            
            for(Iterator<T> l= lista2.iterator(); l.hasNext(); )
                this.addFin(l.next());
            
        }else return false;
        
        return true;
        
    }
}//Fin de la Clase