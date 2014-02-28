package ufps.util;
import java.io.*;

/**
 * Clase que permite escribir en un archivo de texto plano
 * @author Marco Adarme
 * @version 2.0
 */
public class ArchivoEscribirTexto
{
	
	private String filename;
	private PrintWriter escr;
	
        /**
         * Contructor con parametros de la clase ArchivoEscribirTexto
         * @param filename es un tipo String y contiene el nombre del archivo a escribir
         * @param siDeseaAdd es un tipo boolean, true si se desea agregar o false crear
         */
	public ArchivoEscribirTexto(String filename, boolean siDeseaAdd) {
            
            try{
                
                this.filename=filename;
		escr= new PrintWriter(new BufferedWriter(new FileWriter(filename,siDeseaAdd)));
                
            }catch( IOException e) {
                System.out.println(e);
            }
            
        }
        
        /**
         * Método que permite escribir en el archivo con salto de linea
         * @param msg es de tipo String y contiene los datos que se desea incluir en el archivo
         * @throws IOException Excepcion para controlar error de entrada al escribir en el archivo
         */		
	public void println(String msg) throws IOException {
            
            escr.println(msg);
            
        }
        
        /**
         * Método que permite escribir en el archivo con salto de linea
         * @param msg es de tipo integer y contiene los datos que se desea incluir en el archivo
         * @throws IOException Excepcion para controlar error de entrada al escribir en el archivo
         */
        public void println(int msg) throws IOException {
            
            escr.println(msg);
            
        }
        
        /**
         * Método que permite escribir en el archivo con salto de linea
         * @param msg es de tipo float y contiene los datos que se desea incluir en el archivo
         * @throws IOException Excepcion para controlar error de entrada al escribir en el archivo
         */
	public void println(float msg) throws IOException {
            
            escr.println(msg);
            
        }
		
	/**
         * Método que permite escribir en el archivo con salto de linea
         * @param msg es de tipo byte y contiene los datos que se desea incluir en el archivo
         * @throws IOException Excepcion para controlar error de entrada al escribir en el archivo
         */	
	public void println(byte msg) throws IOException {
            
            escr.println(msg);
            
        }
	
        /**
         * Método que permite escribir en el archivo con salto de linea
         * @param msg es de tipo boolean y contiene los datos que se desea incluir en el archivo
         * @throws IOException Excepcion para controlar error de entrada al escribir en el archivo
         */
	public void println(boolean msg) throws IOException {
            
            escr.println(msg);
            
        }
        
        /**
         * Método que permite escribir en el archivo con salto de linea
         * @param msg es de tipo short y contiene los datos que se desea incluir en el archivo
         * @throws IOException Excepcion para controlar error de entrada al escribir en el archivo
         */		
	public void println(short msg) throws IOException {
            
            escr.println(msg);
            
        }
        
	/**
         * Método que permite escribir en el archivo con salto de linea
         * @param msg es de tipo double y contiene los datos que se desea incluir en el archivo
         * @throws IOException Excepcion para controlar error de entrada al escribir en el archivo
         */		
	public void println(double msg) throws IOException {
            
            escr.println(msg);
            
        }
        
	/**
         * Método que permite escribir en el archivo con salto de linea
         * @param msg es de tipo char y contiene los datos que se desea incluir en el archivo
         * @throws IOException Excepcion para controlar error de entrada al escribir en el archivo
         */	
	public void println(char msg) throws IOException {
            
            escr.println(msg);
            
        }
		
		
	/********************************print*****************************/
        
        /**
         * Método que permite escribir datos al archivo
         * @param datos es de tipo T y contiene los datos que sera escritos en el archivo
         * @return <T> 
         */
	public <T> void escribir(T datos) {
            
            try{
                
                escr.println(datos.toString());
                
            }catch(Exception e) {
                
                System.err.print(e.getMessage());
                
            }
            
        }
        
        /**
         * retorna la ruta absoluta del archivo 
         * @return un String que contiene la informacion de la ruta absoluta del archivo
         */		
	public String ruta(){
            
            return new File(this.filename).getAbsolutePath();
            
        }
        
        /**
         * Método por el cual se cierra la conexion con el archivo
         */
	public void close() {
            
            try {
                
                this.escr.close();
                
            }catch(Exception e) {
                
                System.err.print(e.getMessage());
                
            }
            
        }
	
}//Fin de la clase