package pruebas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ej9 implements AutoCloseable{

	private BBDD bd = null;
	private String user;
	private String url;
	private String password;
	private String insertarDatos;
	
	
	public void datosTransaccion() {

		ArrayList<String> sentencia = leerSQL(insertarDatos);
		bd.insertarDatosTransaccion(sentencia);
		System.out.println("Transaccion completada");
		
	}
	
	public ArrayList<String> leerSQL(String ruta) {
		ArrayList<String>contenido = new ArrayList();
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))){
			String linea;
			while((linea = br.readLine()) != null) {
				contenido.add(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contenido;
	}
	
	public ej9() {	
		leerDatos();
		bd = new BBDD(url, user, password);
	
	}
	
	
	public void leerDatos() {
	    try (BufferedReader br = new BufferedReader(new FileReader("./bd.config"))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            if (linea.startsWith("url=")) url = linea.substring(4);
	            else if (linea.startsWith("user=")) user = linea.substring(5);
	            else if (linea.startsWith("password=")) password = linea.substring(9);
	            else if(linea.startsWith("insertarDatos=")) insertarDatos = linea.substring(14);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public void close() {
		// TODO Auto-generated method stub
		if(bd!=null) {
			bd.close();
		}
	}
}
