package Teoria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ej11 implements AutoCloseable{

	private BBDD bd = null;
	private String user;
	private String url;
	private String password;

	
	public void modificarConProcedimiento(int[]ids, boolean estado) {
		bd.modificarTareaConcreta(ids, estado);
	}
	
	

	public ej11() {
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
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void close(){
		// TODO Auto-generated method stub
		if(bd!=null) {
			bd.close();
		}
	}
}
