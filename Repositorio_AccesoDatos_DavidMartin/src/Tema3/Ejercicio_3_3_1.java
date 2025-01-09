package Tema3;

import java.util.Date;
import java.util.List;

public class Ejercicio_3_3_1 implements AutoCloseable{

	Ejercicio_3_3_1_BBDD bd = null;
	
	public Ejercicio_3_3_1(String pathBD) {
		bd = new Ejercicio_3_3_1_BBDD(pathBD);
	}
	
	public void mostrarTareasDescripcion(String cadena) {
		List<Tarea>listaTareas = bd.mostrarTareasConDescripcion(cadena);
		for(Tarea t : listaTareas) {
			System.out.println("Tarea: " + t);
		}
	}
	
	public void mostrarFechasIncluidas(Date fecha1, Date fecha2) {
		List<Tarea>listaTareas = bd.mostrarFechasIncluidas(fecha1, fecha2);
		for(Tarea t : listaTareas) {
			System.out.println("Tarea: " + t);
		}
	}
	
	public void mostrarFechasExcluidas(Date fecha1, Date fecha2) {
		List<Tarea>listaTareas = bd.mostrarFechasExcluidas(fecha1, fecha2);
		for(Tarea t : listaTareas) {
			System.out.println("Tarea: " + t);
		}
	}
	
	public void modificarFinalizadaID(int id, boolean nuevoEstado) {
		bd.modificarFinalizada(id, nuevoEstado);
	}

	@Override
	public void close() {
		if(bd!=null) {
			try {
				bd.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
