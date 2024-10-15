package Tema1;

import java.io.File;
import java.io.FilenameFilter;

public class Ejercicio_2_2_1 implements FilenameFilter{

	/* 
	 * 
	 * Desarrolla una clase que contenga un método que muestre por pantalla todos los directorios que en la ruta raíz del proyecto 
	 * contengan una cadena pasada por parámetro. 
	 * Emplea un método de Test para ejecutar el método de la clase al que nos estamos refiriendo, pasando por parámetro 
	 * la cadena "ing". 
	 * 
	 * */

String cadena;
	
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public Ejercicio_2_2_1() {
		
	}

	@Override
	public boolean accept(File dir, String name) {
		return (name.contains(cadena) && dir.isDirectory());
	}
	
	public void mostrarDirectorio(String texto) {
		try {
			File directorio = new File(".");
			Ejercicio_2_2_1 objetoClase = new Ejercicio_2_2_1();
			objetoClase.setCadena(texto);
			String[] listaDirectorios = directorio.list(objetoClase);
			
			for(String d : listaDirectorios) {
				System.out.println(d);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
