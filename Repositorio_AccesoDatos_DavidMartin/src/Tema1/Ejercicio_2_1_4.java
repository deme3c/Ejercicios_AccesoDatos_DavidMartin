package Tema1;

import java.io.File;

public class Ejercicio_2_1_4 {

	// Ejercicio 2.1.4
	/*
	 * Sobre la clase anterior crea un método que permita, partiendo de un
	 * directorio que tengas en tu sistema de archivos con 5 o más niveles, mostrar
	 * por pantalla el tamaño de cada directorio padre. Emplea un método de Test
	 * para ejecutar el método de la clase.
	 */
	
	public static void mostrarSizeDirectorioPadre(File fichero214) {

		long size = 0;
		if (fichero214.isFile()) {
			size = fichero214.length();
		} else {
			size = calcularTamañoCarpeta(fichero214);
		}

		System.out.println("Nombre: " + fichero214.getName() + ", tamaño: " + size);
		File padre214 = fichero214.getParentFile();

		do {
			size = calcularTamañoCarpeta(padre214);
			if (padre214.getParentFile() == null) {
				System.out.println("Nombre: " + padre214.getAbsolutePath() + ", tamaño: " + size);
				break;
			}
			else {
				System.out.println("Nombre: " + padre214.getName() + ", tamaño: " + size);
			}

			padre214 = padre214.getParentFile();
		} while (padre214 != null);
	}
	
	
	
	public static long calcularTamañoCarpeta(File carpeta) {
		long size = 0;
		File[] ficheros = carpeta.listFiles();

		if (ficheros != null) {
			for (File f : ficheros) {
				if (f.isFile()) {
					size += f.length();
				} else {
					// size += calcularTamañoCarpeta(f);
				}
			}
		}
		return size;
	}
	
	
}
