package Tema1;

import java.io.File;

public class Ejercicio_2_1_3 {

	/*
	 * Sobre la clase anterior crea un método que permita mostrar, respecto del
	 * fichero que contiene la clase, la siguiente información: el nombre del
	 * fichero, la ruta, la ruta absoluta, si se puede leer del fichero, si se puede
	 * escribir en el fichero, el tamaño del fichero, el nombre del directorio
	 * padre. Emplea un método de Test para ejecutar el método de la clase.
	 */
	
	
	public static void datosFichero(File fichero) {
		System.out.println("Nombre: " + fichero.getName());
		System.out.println("Ruta: " + fichero.getPath());
		System.out.println("Ruta abosoluta: " + fichero.getAbsolutePath());
		System.out.println("¿Se puede leer? " + (fichero.canRead() ? "Sí" : "No"));
		System.out.println("¿Se puede escribir? " + (fichero.canWrite() ? "Sí" : "No"));
		System.out.println("Tamaño: " + fichero.length());
		System.out.println("Nombre directorio padre: " + fichero.getParent());
	}
	
}
