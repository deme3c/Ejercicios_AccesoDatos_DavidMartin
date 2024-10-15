package Tema1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio_3_1_1 {

	/* Ejercicio 3.1.1 
	 * 
	 * Se implementa una clase con un método que escriba en un fichero una cadena. 
	 * Tanto el nombre del fichero como la cadena se pasarán como parámetros al método anterior. 
	 * Después de registrar en el fichero la cadena, el método a implementar permitirá añadir al final del fichero un asterisco.
	 * 
	 *  Se implementa a continuación un segundo método en la clase que añada al fichero anterior un array de nombres. 
	 *  Cada nombre se escribirá en una línea del fichero.
	 *	Se implementa por último un método que reciba un objeto de tipo File para identificar al fichero escrito y sobrescrito en los métodos anteriores. 
	 *	Este último método realizará una lectura del contenido del fichero, identificando junto a cada carácter el valor numérico correspondiente.
	 *	
		*/

	public void leerFichero(File fichero) {
		try {
			FileReader fr = new FileReader(fichero);
			int i;
			while ((i = fr.read()) != -1) {
				System.out.println((char)i+" : "+i);
			}
			fr.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addNames(String ruta) {

		try {
			File fichero = new File(ruta);
			FileWriter fw = new FileWriter(fichero, true);
			String[] nombres = {"Son Goku","Vegeta","Piccolo"};
			fw.write(System.lineSeparator());
			for(String n : nombres) {
				fw.write(n);
				fw.write(System.lineSeparator());
			}
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void escribirCadena(String ruta, String cadena){
		
		try {
			File fichero = new File(ruta);
			FileWriter fw = new FileWriter(fichero, true);
			char[] cad = cadena.toCharArray();
			
			for (int i = 0; i < cad.length; i++) {
				fw.write(cad[i]);
			}
			fw.write(System.lineSeparator());
			fw.write("*");
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
