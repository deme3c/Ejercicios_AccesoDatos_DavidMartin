import java.io.File;
import java.io.IOException;

public class mainTeoria1 {

	public static void main(String[] args) {

//		File f = new File("./prueba.txt");
//		
//		try {
//			boolean creacion = f.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		File e = new File(".");
//		String[] Nombres = e.list();
//		for(int i=0; i<Nombres.length; i++) {
//			System.out.println(Nombres[i]);
//		}
//		
//		System.out.println("Operacion terminada");

		// Ejercicio 2.1.1
		/*
		 * Desarrolla una clase que indique por pantalla los elementos que forman parte
		 * de la ruta raíz de un proyecto java. En el caso de que sea un fichero
		 * mostrará la frase: Nombre del fichero: <nombre_fichero>. En el caso de que
		 * sea un directorio mostrará la frase: Nombre del directorio: <nombre_fichero>
		 */

//		File e = new File(".");
//		File[] f = e.listFiles();
//		
//		for(int i=0; i<f.length; i++) {
//			if(f[i].isFile()) {
//				System.out.println("Nombre del fichero: " +f[i].getName());
//			}
//			else if(f[i].isDirectory()) {
//				System.out.println("Nombre del directorio: " + f[i].getName());
//			}	
//		}

		// Ejercicio 2.1.2
		/*
		 * Desarrolla una clase en la que se puedan ejecutar dos operaciones. La primera
		 * creará un directorio que tenga por ruta: C:/directorios_y_ficheros/prueba. A
		 * continuación, y sobre el directorio prueba, creará un fichero llamado
		 * fichero_prueba.txt. La segunda operación eliminará todo rastro de la primera
		 * operación. Emplea métodos de Test para ejecutar estos dos métodos. Mediante
		 * la clase File, podemos ver si un fichero cualquiera, digamos por ejemplo
		 * texto.txt, existe o no. Para ello, nos valemos del método exists() de la
		 * clase File.
		 */

		// crearFicheroDirectorio();
		// borrarDirectorioFichero();

		// Ejercicio 2.1.3
		/*
		 * Sobre la clase anterior crea un método que permita mostrar, respecto del
		 * fichero que contiene la clase, la siguiente información: el nombre del
		 * fichero, la ruta, la ruta absoluta, si se puede leer del fichero, si se puede
		 * escribir en el fichero, el tamaño del fichero, el nombre del directorio
		 * padre. Emplea un método de Test para ejecutar el método de la clase.
		 */

		// File fichero213 = new
		// File("C:/directorios_y_ficheros/prueba/fichero_prueba.txt");
		// datosFichero(fichero213);

		// Ejercicio 2.1.4
		/*
		 * Sobre la clase anterior crea un método que permita, partiendo de un
		 * directorio que tengas en tu sistema de archivos con 5 o más niveles, mostrar
		 * por pantalla el tamaño de cada directorio padre. Emplea un método de Test
		 * para ejecutar el método de la clase.
		 */

//		File fichero214 = new File(
//				"C:\\Users\\dmart\\eclipse-workspace\\carreraCaballos\\src\\carreraCaballos\\Caballo.java");
//		long size = 0;
//		if (fichero214.isFile()) {
//			size = fichero214.length();
//		} else {
//			size = calcularTamañoCarpeta(fichero214);
//		}
//
//		System.out.println("Nombre: " + fichero214.getName() + ", tamaño: " + size);
//		File padre214 = fichero214.getParentFile();
//
//		do {
//			size = calcularTamañoCarpeta(padre214);
//			if (padre214.getParentFile() == null) {
//				System.out.println("Nombre: " + padre214.getAbsolutePath() + ", tamaño: " + size);
//				break;
//			}
//			else {
//				System.out.println("Nombre: " + padre214.getName() + ", tamaño: " + size);
//			}
//
//			padre214 = padre214.getParentFile();
//		} while (padre214 != null);
		
		

				
		
		
		
		
		
		
		
		
		

	} // ************************** main ***********************************//

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

	public static void datosFichero(File fichero) {
		System.out.println("Nombre: " + fichero.getName());
		System.out.println("Ruta: " + fichero.getPath());
		System.out.println("Ruta abosoluta: " + fichero.getAbsolutePath());
		System.out.println("¿Se puede leer? " + (fichero.canRead() ? "Sí" : "No"));
		System.out.println("¿Se puede escribir? " + (fichero.canWrite() ? "Sí" : "No"));
		System.out.println("Tamaño: " + fichero.length());
		System.out.println("Nombre directorio padre: " + fichero.getParent());
	}

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


