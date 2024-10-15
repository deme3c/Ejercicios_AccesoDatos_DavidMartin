package Tema1;

import java.io.File;

public class Ejercicio_2_1_1 {

	/*
	 * Ejercicio 2.1.1
	 * 
	 * Desarrolla una clase que indique por pantalla los elementos que forman parte
	 * de la ruta raíz de un proyecto java. En el caso de que sea un fichero
	 * mostrará la frase: Nombre del fichero: <nombre_fichero>. En el caso de que
	 * sea un directorio mostrará la frase: Nombre del directorio: <nombre_fichero>
	 */

	public void mostrarElementos() {
		File e = new File(".");
		File[] f = e.listFiles();

		for(int i = 0;i<f.length;i++) {
			if (f[i].isFile()) {
				System.out.println("Nombre del fichero: " + f[i].getName());
			} else if (f[i].isDirectory()) {
				System.out.println("Nombre del directorio: " + f[i].getName());
			}
		}
	}
	

}
