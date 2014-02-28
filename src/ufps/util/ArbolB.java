package ufps.util;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Iterator;

/**
 * Clase para el manejo de un Arbol Binario no ordenado
 * @author Marco Adarme
 * @version 2.0
 */
public class ArbolB<T>
	{

		protected NodoB<T> raiz;


     /**
      * Crea un árbol con una raíz predefinida
      * @param raiz  un tipo NodoB<T> , almacena la dirección de memoria de un nodo de un árbol binario
      */
    public ArbolB(NodoB<T> raiz) {
        this.raiz = raiz;
    }


/**
 *  Crea un árbol binario vacío
 * 
 */
		public ArbolB()
			{
				this.raiz=null;
			}

                /**
                 *  Retorna la raíz del árbol
                 * @return un tipo de objeto de la clase NodoB<T> con la dirección de memoria de la raíz
                 * del árbol
                 */
                
		public NodoB<T> getRaiz()
			{
				return this.raiz;
			}

                /**
                 * Cambia la raíz del árbol por otra
                 * @param r recibe una nueva raiz para el árbol
                 */
                
		public void setRaiz(NodoB<T> r)
			{
				this.raiz=r;
			}

/**
 *  Retorna un iterador con el recorrido preOrden del árbol binario
 * @return un iterador de la clase Iterator de la java.util
 */
                
		public Iterator<T> preOrden()
			{
				ListaS<T> l=new ListaS<T>();
				preOrden(this.getRaiz(),l);
				return (l.iterator());

			}

		private void  preOrden(NodoB<T> r, ListaS<T> l)
			{


				if(r!=null){
					l.addFin(r.getInfo());
					preOrden(r.getIzq(), l);
					preOrden(r.getDer(), l);

					}

			}

/**
 *  Retorna un iterador con el recorrido inOrden del árbol binario
 * @return un iterador de la clase Iterator de la java.util
 */


		public Iterator<T> inOrden()
			{
				ListaS<T> l=new ListaS<T>();
				inOrden(this.getRaiz(),l);
				return (l.iterator());

			}

		private void  inOrden(NodoB<T> r, ListaS<T> l)
			{


				if(r!=null){
					inOrden(r.getIzq(), l);
					l.addFin(r.getInfo());
					inOrden(r.getDer(), l);

					}

			}

/**
 *  Retorna un iterador con el recorrido postOrden del árbol binario
 * @return un iterador de la clase Iterator de la java.util
 */

	public Iterator<T> posOrden()
			{
				ListaS<T> l=new ListaS<T>();
				posOrden(this.getRaiz(),l);
				return (l.iterator());

			}

		private void  posOrden(NodoB<T> r, ListaS<T> l)
			{


				if(r!=null){
					posOrden(r.getIzq(), l);
					posOrden(r.getDer(), l);
					l.addFin(r.getInfo());
					}

			}




/**
 * Obtiene la cardinalidad del árbol binario
 * @return un entero con la cantidad de elementos del árbol
 */

		public int cardinalidad()
			{
				return(cardinalidad(this.getRaiz()));
			}

		private  int cardinalidad(NodoB<T> r)
		{
			if(r==null)
				return 0;
		return (cardinalidad(r.getIzq())+1+cardinalidad(r.getDer()));
		}

/**
 *  Devuelve una copia del árbol. Los elementos almacenados no se copian, solo la estructura
 * morfológica del árbol.
 * @return un árbol binario
 */

		public ArbolB<T> clonar()
			{
				ArbolB<T> t=new ArbolB<T>();
				t.setRaiz(clonar(this.getRaiz()));
				return(t);
			}


		private NodoB<T> clonar(NodoB<T> r)
			{

				if(r==null)
				return r;
			else
				{
				NodoB<T> aux=new NodoB<T>(r.getInfo(), clonar(r.getIzq()), clonar(r.getDer()));
				//OTRA FORMA DE puedeserquealgoimprimaLEMENTAR:-->
				//NodoB aux=new NodoB(r.getInfo(), null, null);
				//aux.setIzq(clonar(r.getIzq()))
				//aux.setDer(clonar(r.getDer()));
				return aux;
				}
			}

/**
 *  Retorna el código  Łukasiewicz del árbol binario. Esté código etiqueta
 * los nodos internos con "a" y los externos con una "b" y realiza el recorrido
 * en preorden con estas convenciones
 * @return  un String con el código  Łukasiewicz del árbol binario
 */ 
		public String Luca()
			{
				return(Luca(this.raiz));
			}

		private String Luca(NodoB<T> r)
			{
				if(r==null)
					return("b");
				return("a"+Luca(r.getIzq())+Luca(r.getDer()));
			}


/**
 * Retorna en un String el recorrido preOrden del árbol. Esté método se realiza con 
 * <br/>con instrucciones iterativas
 * @return 
 */
		public String preOrden_Iterativo()
		{
			return(preOrden_Iterativo(this.raiz));
		}

		public String preOrden_Iterativo(NodoB<T> r)
			{

				Pila<NodoB> p=new Pila<NodoB>();
				String rr="";
				while(r!=null)
					{
						p.push(r);
						rr+=r.getInfo().toString()+"-";
						r=r.getIzq();
					}
				while(!p.esVacio())
					{
						r=p.pop();
						r=r.getDer();
						while(r!=null)
							{
								rr+=r.getInfo().toString()+"-";
								p.push(r);
								r=r.getIzq();
							}
					}
			return(rr);
			}
/**
 * Retorna en un String el recorrido inOrden del árbol. Esté método se realiza con 
 * <br/>con instrucciones iterativas
 * @return 
 */

		public String inOrden_Iterativo()
		{
			return(inOrden_Iterativo(this.raiz));
		}

		public String inOrden_Iterativo(NodoB<T> r)
			{

				Pila<NodoB> p=new Pila<NodoB>();
				String rr="";
				while(r!=null)
					{
						p.push(r);
						r=r.getIzq();
					}
				while(!p.esVacio())
					{
						r=p.pop();
						rr+=r.getInfo().toString()+"-";
						r=r.getDer();
						while(r!=null)
							{
								p.push(r);
								r=r.getIzq();
							}
					}
			return(rr);
			}

                /**
 *  Retorna un iterador con el recorrido por nivles del árbol binario
 * @return un iterador de la clase Iterator de la java.util
 */

		public Iterator<T> impNiveles()
			{
				ListaS<T> l=new ListaS<T>();
				if(!this.esVacio())
				{
					Cola<NodoB> c=new Cola<NodoB>();
					c.enColar(this.getRaiz());
					NodoB<T> x=null;
					while(!c.esVacio())
						{
							x=c.deColar();
							l.addFin(x.getInfo());
							if(x.getIzq()!=null)
								c.enColar(x.getIzq());
							if(x.getDer()!=null)
								c.enColar(x.getDer());
						}
				}
				return (l.iterator());
			}

                
                /**
                 * Elimina las hojas(nodos terminales) del árbol binario.
                 */
                
		public void podar()
			{
				podar(this.raiz);
			}

		private void podar(NodoB<T> x)
			{
				if (x==null)
					return;
				if(this.esHoja(x.getIzq()))
						x.setIzq(null);
				if(this.esHoja(x.getDer()))
						x.setDer(null);
				podar(x.getIzq());
				podar(x.getDer());
			}

		protected boolean esHoja(NodoB<T> x)
			{
				return (x!=null && x.getIzq()==null && x.getDer()==null);
			}

                
               /**
                * Dado un dato almacenado en el árbol , retorna el padre de ese dato. Se parte
                * de la premisa que el árbol no contiene elementos repetidos.
                * @param info dato que se desea buscar
                * @return el padre del dato almacenado en el árbol, null en caso no existir el dato
                */ 
                
		public T padre(T info)
			{
				if(info==null || this.raiz==null)
					return null;
				NodoB<T> x=padre(this.raiz,info);
				if(x==null)
					return null;
				return(x.getInfo());
			}

		private NodoB<T> padre(NodoB<T> x, T info)
			{
				if(x==null)
					return null;
				if((x.getIzq()!=null && x.getIzq().getInfo().equals(info))|| (x.getDer()!=null && x.getDer().getInfo().equals(info)))
					return (x);
				NodoB<T> y=padre(x.getIzq(),info);
				if(y==null)
					return(padre(x.getDer(),info));
				else
					return(y);
			}

/**
 *  Retorna si el árbol contiene o no elementos.
 * @return true si el árbol binario esta vacío o false en caso contrario
 */
		public boolean esVacio()
		{
			return (this.raiz==null);
		}


  /**
 *  Retorna un iterador con las hojas del árbol binario 
 * @return un iterador de la clase Iterator de la java.util
 */
                
         public Iterator<T> getHojas()
         {
         ListaS<T> l=new ListaS<T>();
         getHojas(this.raiz, l);
         return (l.iterator());
         }

         private void getHojas(NodoB<T> r, ListaS<T> l)
         {
          if (r!=null)
          {
            if(this.esHoja(r))
                l.addFin(r.getInfo());
         getHojas(r.getIzq(), l);
         getHojas(r.getDer(), l);
          }

         }

         
 /**
 *  Retorna true si existe un dato en el árbol binario, o false en caso contrario.
 * Es necesario para que el método funcione que los objetos almacenados en el árbol
 * binario tengan sobreescrito el método equals.
 * @return un boolean , true si el dato está o false en caso contrario.
 */
         
         //La clase T debe tener sobreescrito el metodo equals
         public boolean esta(T info)
         {
            return (esta(this.raiz,info));
         }

         private boolean esta(NodoB<T> r, T info)
         {
            if(r==null)
                return (false);
            if(r.getInfo().equals(info))
                return (true);
            return(esta(r.getIzq(),info) || esta(r.getDer(),info));
         }

         protected  DefaultMutableTreeNode crearJtree(NodoB<T> r,String msg)
	{

		if (esHoja(r))
			return(new DefaultMutableTreeNode(msg+r.getInfo().toString()));
		DefaultMutableTreeNode x=new DefaultMutableTreeNode(msg+r.getInfo().toString());
                if (r.getIzq()!=null)
                    x.add(crearJtree(r.getIzq(),"Izq->"));
                if (r.getDer()!=null)
                    x.add(crearJtree(r.getDer(),"Der->"));
		return x;

	}

         
         /**
          *  Crea un árbol de la clase JTree. Esta clase permite dibujar el árbol utilizando una distribución
         *  de ficheros y directorios de un explorador de archivos convencional
          * @return un JTree con el árbol binario que se tiene creado
          */
         
        public JTree darJTree()
        {
        DefaultMutableTreeNode x=new DefaultMutableTreeNode("ARBOL-VACIO");
        if(this.esVacio())
            return (new JTree(x));
        return (new JTree(crearJtree(this.raiz,"Raiz(T)->")));
        }


        /**
         * Retorna el árbol binario creado a partir del recorrido preOrden e inOrden
         * @param Pre vector con el preOrden del árbol
         * @param In  vector con el inOrden del árbol
         * @return un árbol binario
         */
        
    public ArbolB<T> crearArbol(T Pre[], T In[])
    {



    if(!validarPreIn(Pre, In))
          return(new ArbolB<T>());


    NodoB<T> rr=crearRaizArbol(Pre, In);
     return (new ArbolB<T>(rr));
    }


     private NodoB<T> crearRaizArbol(T Pre[], T In[])
      {

          NodoB<T> nuevo;
          Object DerechosPre[]=new Object[Pre.length];
          Object IzquierdosPre[]=new Object[Pre.length];
          Object DerechosIn[]=new Object[In.length];
          Object IzquierdosIn[]=new Object[In.length];
          int contador =0,con1 = 0 ,indiceEncontrado,con2 = 0;;
          if (Pre[0]!=null && In[0]!=null)
                {
                nuevo = new NodoB<T>();
                nuevo.setInfo(Pre[0]);
            while( contador <In.length&& !In[contador].equals(Pre[0]))
                {
                IzquierdosIn[contador] = In[contador];
                contador++;
                }
              if(contador==In.length)
                  return (null);

               indiceEncontrado = contador;
               //IzquierdosIn[contador]= null;
                if(In[contador]!=null)
                    {
                        contador++;
                        while(contador<In.length && In[contador]!=null)
                        {
                            DerechosIn[con1] = In[contador];
                            contador++ ;
                            con1++;
                        }
                    }
                 //DerechosIn[con1]= null;
                 contador = 1;
                 con1 = 0;

                 while(contador!=Pre.length && Pre[contador]!=null)
                        {
                        if(contador<=indiceEncontrado)
                        {
                       IzquierdosPre[con1]=Pre[contador];
                        con1++;
                        }
                        else
                        {
                        DerechosPre[con2]=Pre[contador];
                        con2++;
                        }
                        contador++;
                        }

                       //IzquierdosPre[con1] = null;
                        //DerechosPre[con2] =null;

                nuevo.setIzq(crearRaizArbol((T[])IzquierdosPre,(T[])IzquierdosIn));
                nuevo.setDer(crearRaizArbol((T[])DerechosPre,(T[])DerechosIn));
                return nuevo;
                }

     return null;
      }


       private boolean validarPreIn(T Pre[], T In[])
    {

        if(Pre.length!=In.length)
            return false;
        if(!validarRepetido(Pre))
            return false;
        if(!validarRepetido(In))
            return false;

        return(true);

    }

    private boolean validarRepetido(T v[])
    {
      int con=0;
      for(int i=0;i<v.length;i++)
            {
                for(int j=i+1;j<v.length;j++)
                    if(v[i].equals(v[j]))
                        con++;
                if(con>1)
                    return (false);
            con=0;
            }
     return (true);
    }






}
