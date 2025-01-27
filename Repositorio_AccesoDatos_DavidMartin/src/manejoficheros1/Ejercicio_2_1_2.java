package manejoficheros1;

import java.io.File;
import java.io.IOException;

public class Ejercicio_2_1_2 {

	/*
	 * Ejercicio 2.1.2
	 * Desarrolla una clase en la que se puedan ejecutar dos operaciones. La primera
	 * creará un directorio que tenga por ruta: C:/directorios_y_ficheros/prueba. A
	 * continuación, y sobre el directorio prueba, creará un fichero llamado
	 * fichero_prueba.txt. La segunda operación eliminará todo rastro de la primera
	 * operación. Emplea métodos de Test para ejecutar estos dos métodos. Mediante
	 * la clase File, podemos ver si un fichero cualquiera, digamos por ejemplo
	 * texto.txt, existe o no. Para ello, nos valemos del método exists() de la
	 * clase File.
	 */
	
	
	public void crearFicheroDirectorio() {
		File directorio = new File("C:/directorios_y_ficheros/prueba");
		directorio.mkdirs();
		File fichero = new File("C:/directorios_y_ficheros/prueba/fichero_prueba.txt");
		try {
			fichero.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void borrarDirectorioFichero() {
		File fichero = new File("C:/directorios_y_ficheros/prueba/fichero_prueba.txt");
		fichero.delete();
		File directorio = new File("C:/directorios_y_ficheros/prueba");
		directorio.delete();
		File directorio2 = new File("C:/directorios_y_ficheros");
		directorio2.delete();

	}
	
}


