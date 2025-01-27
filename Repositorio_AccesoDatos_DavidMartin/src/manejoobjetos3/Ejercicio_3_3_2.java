package manejoobjetos3;

import java.util.ArrayList;

public class Ejercicio_3_3_2 implements AutoCloseable{

	Ejercicio_3_3_2_BBDD bd = null;
	Ejercicio_3_3_2_GestionDatos gTareas = null;
	
	public Ejercicio_3_3_2(String pathDB) {
		bd = new Ejercicio_3_3_2_BBDD(pathDB);
		gTareas = new Ejercicio_3_3_2_GestionDatos(bd);
	}
	
	public Tarea nuevaTarea(int id, String descripcion, String fechaInicio, String fechaFin, boolean finalizada, TipoTarea tipoTarea){
		return gTareas.nuevaTarea(id, descripcion, fechaInicio, fechaFin, finalizada, tipoTarea);
	}

	@Override
	public void close() {
		if(bd!=null) {
			bd.close();
		}
		
	}
	
	
	
}
