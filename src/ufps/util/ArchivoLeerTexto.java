package ufps.util;
import java.io.*;
import java.util.Vector;
/**
 * Clase que permite leer en un archivo de texto plano
 * @author Marco Adarme
 * @version 2.0
 */
public class ArchivoLeerTexto
{
	
	
	private String filename;
	private BufferedReader reader;
	private String delimitador;
	
	/**
         * Contructor con parametros de la clase ArchivoLeerTexto
         * @param filename es un tipo String y contiene el nombre del archivo a leer
         */
	public ArchivoLeerTexto(String filename)  //throws IOException
		{
			this.filename=filename;
			try{
				this.reader=new BufferedReader(new FileReader(filename));
			}
			catch (IOException e)
				{
					System.err.print(e.toString());
				}
			
		}
		
		
        
        /**
         * Contructor con parametros de la clase ArchivoLeerTexto
         * @param filename es un tipo String y contiene el nombre del archivo a leer
         * @param delimitador un tipo String, y contiene el caractér por el cuál se desea partir cada línea del archivo
         */
        
	public ArchivoLeerTexto(String filename, String delimitador)  //throws IOException
		{
			this.filename=filename;
			this.delimitador=delimitador;
			try{
				this.reader=new BufferedReader(new FileReader(filename));
			}
			catch (IOException e)
				{
					System.err.print(e.toString());
				}
			
		}
		
	/**
         * Método que lee una línea desde la posición actual del cursor
         * @return  un String con la línea leída.
         */
        
	public String readLine() //throws IOException
		{
		
			try
			{
				return (this.reader.readLine());
			}
			catch (IOException e)
				{
					System.err.print(e.toString());
				}
		return null;	
		}
        
        /**
         * Método por el cual se cierra la conexion con el archivo
         */
		
	public void close() //throws IOException
		{
			
			try
			{
				this.reader.close();
			}
			catch (IOException e)
				{
					System.err.print(e.toString());
				}
		}
		
	/**
         * Método que convierte el archivo de texto plano a una matriz, donde cada línea es una fila
         * de la matriz y cada columna es el campo que esta representado por el delimitador del archivo.
         * Esté método debe ser usado con el constructor que recibe dos paramétros
         * @return  una matriz con la representación del archivo
         */
        
	public String [][]leerTodo() //throws IOException
	{
		
	String Linea=this.readLine();	
	Vector<Vector<String>> r=new Vector<Vector<String>>();
	while(Linea!=null)		
		{
			String []v=Linea.split(this.delimitador);
			Vector<String> p=new Vector<String>();
			for(String dato:v)
			{
					p.add(dato);
					System.out.print(dato+"-");
			}
			
			r.add(p);
		Linea=this.readLine();		
		}
	
	String matrix[][]=new String[r.size()][];
	int i=0;
	for(Vector<String> v:r)
	{
		
		matrix[i]=new String[v.size()];
		int j=0;
		for(String dato:v)
			matrix[i][j++]=dato;
		i++;
		
	}
	this.close();
	return (matrix);
	}
	
}
