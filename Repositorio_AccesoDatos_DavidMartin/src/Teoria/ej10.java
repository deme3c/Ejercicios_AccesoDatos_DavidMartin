package Teoria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ej10 implements AutoCloseable {

	private BBDD bd = null;
	private String user;
	private String url;
	private String password;

	
	public void insertarRegistrosCSV() {
		ArrayList<Tarea>contenido = leerCSV("./script_bbdd/values.csv");
		bd.insertarRegistrosCSV(contenido);
		System.out.println("Datos metidos correctamente");
	}
	
	
	public ArrayList<Tarea> leerCSV(String ruta) {
		ArrayList<Tarea> contenido = new ArrayList();
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			String linea = "";
			try {
				while ((linea = br.readLine()) != null) {
					String[] datos = linea.split(";");
					int id = Integer.parseInt(datos[0]);
					String descripcion = datos[1];
					String fechaInicio = datos[2];
					String fechaFin = datos[3];
					boolean finalizada = Boolean.parseBoolean(datos[4].toUpperCase());

					contenido.add(new Tarea(id, descripcion, fechaInicio, fechaFin, finalizada));

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contenido;
	}

	public ej10() {
		leerDatos();
		bd = new BBDD(url, user, password);
	}

	public void leerDatos() {
		try (BufferedReader br = new BufferedReader(new FileReader("./bd.config"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.startsWith("url="))
					url = linea.substring(4);
				else if (linea.startsWith("user="))
					user = linea.substring(5);
				else if (linea.startsWith("password="))
					password = linea.substring(9);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		if (bd != null) {
			bd.close();
		}
	}
}
