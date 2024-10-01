/* 
Ejercicio 2.3.1 Desarrolla una clase que se componga de cuatro métodos:
1) El primer método permitirá crear un nuevo directorio cuyo nombre se pasará por parámetro.

2) El segundo método permitirá crear un fichero con extensión .txt y necesitará de dos parámetros. Un primer parámetro informará del nombre del directorio y un segundo parámetro informará del nombre del fichero. 
La función retornará un objeto de tipo File en caso de que el fichero se haya creado correctamente y un valor null en caso contrario.

3) El tercer método permitirá crear un fichero con extensión .txt a partir del directorio padre y también necesitará de dos parámetros. 
Un primer parámetro informará de un objeto de tipo File para identificar el directorio padre, y un segundo parámetro informará del nombre del fichero. 
La función retornará un objeto de tipo File en caso de que el fichero se haya creado correctamente y un valor null en caso contrario.

4) El cuarto método permitirá modificar el nombre de un fichero. Necesitará de tres parámetros. El primer parámetro informará de un objeto de tipo File para identificar el fichero cuyo nombre se quiere modificar. El segundo parámetro informará de la carpeta del nuevo fichero. El tercer parámetro informará del nombre del nuevo fichero. */

import java.io.File;
import java.io.IOException;

public class excepcionesUsuario {

	public void metodoUno(String nombre) {
		File f = new File(nombre);

		if (!f.exists()) {
			f.mkdirs();
		} else {
			System.out.println("Este directorio ya existe");
		}
	}

	public File metodoDos(String directorio, String fichero) {
		File d = new File(directorio);
		if (d.exists() && d.isDirectory()) {
			File f = new File(d, fichero + ".txt");
			if (!f.exists()) {
				try {
					f.createNewFile();
					System.out.println("Fichero creado");
					return f;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			} else {
				System.out.println("El fichero ya existe");
				return null;
			}
		} else {
			System.out.println("El directorio no existe");
			return null;
		}

	}

}
