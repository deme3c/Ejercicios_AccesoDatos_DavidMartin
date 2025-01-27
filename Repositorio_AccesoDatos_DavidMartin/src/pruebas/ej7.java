package pruebas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ej7 implements AutoCloseable{

	private String user;
	private String url;
	private String password;
	
	private String rutaCrear;
	private String rutaRellenar;
	
	private BBDD bd = null;
	
	
	public ej7() {
		leerDatos();
		bd = new BBDD(url, user, password);
	}
	
	public void mostrarDatos(String fecha1, String fecha2) {
		String leerDatosSQL = "SELECT * FROM ejercicio_7_1 WHERE fecha_inicio BETWEEN '" + fecha1 + "' AND '" + fecha2 + "';";
		bd.ejecutarQuery(leerDatosSQL);
		System.out.println("Sentencia ejecutada");
	}
	
	
	public void cambiarFinalizada(String[]ids, boolean nuevoEstado) {
		String lista = String.join(",", ids);
		String cambiarBoolean = "UPDATE ejercicio_7_1 SET finalizada = " + nuevoEstado + " WHERE id IN (" + lista + ");" ;
		bd.ejecutarUpdate(cambiarBoolean);
		System.out.println("Campos actualizados!");
	}
	
	public void rellenarTabla() {
		String rellenarDatosSQL = leerSQL(rutaRellenar);
		bd.ejecutarUpdate(rellenarDatosSQL);
		System.out.println("Datos rellenados!");
	}
	
	public void crearTabla() {
		String crearTablaSQL = leerSQL(rutaCrear);
		bd.ejecutarUpdate(crearTablaSQL);
		System.out.println("Tabla creada!");
	}
	
	
	public void leerDatos() {
	    try (BufferedReader br = new BufferedReader(new FileReader("./bd.config"))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            if (linea.startsWith("url=")) url = linea.substring(4);
	            else if (linea.startsWith("user=")) user = linea.substring(5);
	            else if (linea.startsWith("password=")) password = linea.substring(9);
	            else if (linea.startsWith("rutaCrear=")) rutaCrear = linea.substring(10);
	            else if (linea.startsWith("rutaRellenar=")) rutaRellenar = linea.substring(13);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	public String leerSQL(String ruta) {
		String contenido = "";
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))){
			String linea;
			while((linea = br.readLine()) != null) {
				contenido += linea + "\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contenido;
	}

	@Override
	public void close() {
		
		if(bd!=null) {
			bd.close();
			System.out.println("Gestor de base datos cerrado");
		}
	}
	
	
	

}
