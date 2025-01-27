package manejoobjetos3;

import java.util.ArrayList;

import org.neodatis.odb.OID;
import org.neodatis.odb.core.oid.OIDFactory;

public class Ejercicio_3_1_1 implements AutoCloseable {

	private Ejercicio_3_1_1_BBDD db = null;
	
	public Ejercicio_3_1_1() {
		db = new Ejercicio_3_1_1_BBDD();
	}

	
	public void crearInsertarTareas() {
		ArrayList<Tarea> tareas = new ArrayList<>();
		
        TipoTarea tipo1 = new TipoTarea(1, "CMP", "Compra");
        TipoTarea tipo2 = new TipoTarea(2, "STD", "Estudio");
        TipoTarea tipo3 = new TipoTarea(3, "TRP", "Viaje");
        TipoTarea tipo4 = new TipoTarea(4, "MNT", "Mantenimiento");
        TipoTarea tipo5 = new TipoTarea(5, "PRC", "Práctica");
        tareas.add(new Tarea(1, "Comprar manzanas", "2024-02-15", "2024-02-16", true, tipo1));
        tareas.add(new Tarea(2, "Estudiar examen", "2024-05-02", "2024-05-18", true, tipo1));
        tareas.add(new Tarea(3, "Comprar billete para Sidney", "2024-02-15", "2024-05-20", true, tipo2));
        tareas.add(new Tarea(4, "Ir a Australia", "2024-06-01", "2024-08-25", true, tipo2));
        tareas.add(new Tarea(5, "Revisión del coche", "2024-10-08", "2024-10-16", true, tipo3));
        tareas.add(new Tarea(6, "Otra cosa", "2024-10-01", "2024-12-01", false, tipo4));
        tareas.add(new Tarea(7, "Práctica JDBC", "2024-10-30", "2024-11-07", false, tipo4));
        tareas.add(new Tarea(8, "FCT", "2025-03-01", "2025-05-24", false, tipo5));

        for (Tarea tarea : tareas) {
            db.odb.store(tarea);
        } 
	}
	
	public void mostrarTareaMedianteID(int id) {
		db.obtenerObjetoMedianteID(id);
	}

	public void mostrarTareasEnLaBBDD() {
		db.mostrarTareas();
	}
	
	public void mostrarTipoTareas() {
		db.mostrarTipoTarea();
	}
	
	@Override
	public void close()  {
		// TODO Auto-generated method stub
		if(db!=null) {
			try {
				db.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
