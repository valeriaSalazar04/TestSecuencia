package ufps.util;

/**
 *Clase para el manejo de un Arbol Binario de búsqueda (ordenado)
 * @author Marco Adarme
 * @version 2.0
 */
public class ArbolBB<T> extends ArbolB<T>
	{
		
/**
 *  Crea un árbol binario vacío
 * 
 */
		public ArbolBB()
			{
                            super();
			}
		
		
                
                /**
                 *  Inserta un dato en el árbol binario de búsqueda según factor de ordenamiento
                 * @param dato un elemento tipo T que se desea almacenar en el árbol
                 * @return  true si el elemento fue insertado o false en caso contrario
                 */
		public boolean insertar(T dato)
			{
                                
				NodoB<T> rr=this.buscar(dato)?null:insertar(this.raiz, dato);
                                if(rr!=null)
                                     this.setRaiz(rr);
                                return (rr!=null);
			}
			
		private NodoB<T> insertar(NodoB<T> r, T dato)
			{
				
				if(r==null)
					return(new NodoB<T>(dato,null, null));
				int compara=((Comparable)r.getInfo()).compareTo(dato);
				if(compara>0)  // datodelarbol es menor que dato
					r.setIzq(insertar(r.getIzq(), dato));
				else
					if(compara<0) // datodelarbol es mayor que dato
						r.setDer(insertar(r.getDer(), dato));
					else// datodelarbol es igual que dato
                                        {
                                        System.err.println("Error dato duplicado:"+dato.toString());
                                        //return null;
                                        }
				return r;
			}
			
                
                /**
                * Borra un elmento del árbol binario de búsqueda, 
                * manteniendo su propieda de orden, para esto se busca el menor de los derechos y lo intercambia por el dato
		*que desea borrar. La idea del algoritmo es que el dato a borrar 
		*se coloque en una hoja o en un nodo que no tenga una de sus ramas.
		* @param x dato que se desea borrar
                * @return  el dato borrado o null si no lo encontro
                */
		
		public T borrar(T x)
			{
				if(!this.buscar(x))
                                {
                                             	return null;
                                }
				
				NodoB<T> z=borrar(this.raiz,x);
				this.setRaiz(z);
                		return x;
				
			}
		private NodoB<T> borrar(NodoB<T> r, T x)
			{
				if (r==null)
					return null;//<--Dato no encontrado		
				
				int compara=((Comparable)r.getInfo()).compareTo(x);
				if(compara>0)
					r.setIzq(borrar(r.getIzq(), x));
				else
					if(compara<0)
						r.setDer(borrar(r.getDer(), x));
					else
						{
                                                    System.out.println("Encontro el dato:"+x.toString());
                                                    if(r.getIzq()!=null && r.getDer()!=null)
								{
								/*
								 *	Buscar el menor de los derechos y lo intercambia por el dato
								 *	que desea borrar. La idea del algoritmo es que el dato a borrar 
								 *	se coloque en una hoja o en un nodo que no tenga una de sus ramas.
								 **/
								 NodoB<T> cambiar=buscarMin(r.getDer());
								 T aux=cambiar.getInfo();
								 cambiar.setInfo(r.getInfo());
								 r.setInfo(aux);
								 r.setDer(borrar(r.getDer(),x));
								System.out.println("2 ramas") 		;
								}
							else
                                                        {
								r=(r.getIzq()!=null)? r.getIzq():r.getDer();
                                                                System.out.println("Entro cuando le faltan ramas ");
                                                        }
						}
				return r;
			}
		
		/*
		 *			Busca el menor dato del árbol. El menor dato
		 *			del árbol se encuentra en el nodo mas izquierdo.
		 **/
		private NodoB<T> buscarMin(NodoB<T> r)
			{
				for(; r.getIzq()!=null; r=r.getIzq());
				return(r);
			}
		
		
		
/**
 *  Retorna true si existe un dato en el árbol binario de búsqueda, o false en caso contrario.
 * Es necesario para que el método funcione que los objetos almacenados en el árbol
 * binario tengan sobreescrito el método equals.
 * @return un boolean , true si el dato está o false en caso contrario.
 */
         
		public boolean buscar(T x)
			{
				return(buscar(this.raiz, x));
                    
                                
			}
		private boolean buscar(NodoB<T> r, T x)
			{
				if (r==null)
					return (false);
				int compara=((Comparable)r.getInfo()).compareTo(x);
				if(compara>0)
					return(buscar(r.getIzq(),x));
				else
					if(compara<0)
						return(buscar(r.getDer(),x));
					else
						return (true);
			}
		
		
		
		
} //Fin de clase
