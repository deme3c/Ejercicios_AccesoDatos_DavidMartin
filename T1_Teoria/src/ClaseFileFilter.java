import java.io.File;
import java.io.FilenameFilter;

//Ejercicio 2.2.1
/* Desarrolla una clase que contenga un método que muestre por pantalla todos los directorios que en la ruta raíz del proyecto contengan una cadena pasada por parámetro. 
 * Emplea un método de Test para ejecutar el método de la clase al que nos estamos refiriendo, pasando por parámetro la cadena "ing". */

public class ClaseFileFilter implements FilenameFilter {
	
	String cadena;
	
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public ClaseFileFilter() {
		
	}

	@Override
	public boolean accept(File dir, String name) {
		return (name.contains(cadena) && dir.isDirectory());
	}
	
	public void mostrarDirectorio(String texto) {
		try {
			File directorio = new File(".");
			ClaseFileFilter objetoClase = new ClaseFileFilter();
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




//haciendolo desde el constuctor y no desde el metodo:

/* import java.io.File;
import java.io.FilenameFilter;

public class ClaseFileFilter implements FilenameFilter {
	
	String cadena;

	
	public ClaseFileFilter(String extension) {
		super();
		this.cadena = extension;
	}

	@Override
	public boolean accept(File dir, String name) {
		return (name.contains(cadena) && dir.isDirectory());
	}
	
	public void mostrarDirectorio() {
		try {
			File directorio = new File(".");
			String[] listaDirectorios = directorio.list(new ClaseFileFilter(this.cadena));
			
			for(String d : listaDirectorios) {
				System.out.println(d);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}


}
 */
