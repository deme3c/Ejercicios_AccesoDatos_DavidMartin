package manejoobjetos3;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.Objects;

public class Ejercicio_3_3_2_GestionDatos implements AutoCloseable{

	List<Tarea>listaTareas = new ArrayList<Tarea>();
	List<TipoTarea>listaTipoTareas = new ArrayList<TipoTarea>();
	Ejercicio_3_3_2_BBDD bd = null;
	
	public Ejercicio_3_3_2_GestionDatos(Ejercicio_3_3_2_BBDD bd) {
		
		Objects<Tarea>objectsTarea = bd.odb.getObjects(Tarea.class);
		while(objectsTarea.hasNext()) {
			Tarea tarea = objectsTarea.next();
			listaTareas.add(tarea);
		}
		Objects<TipoTarea>objectsTipo = bd.odb.getObjects(TipoTarea.class);
		while(objectsTipo.hasNext()) {
			TipoTarea tipo = objectsTipo.next();
			listaTipoTareas.add(tipo);
		}
		
		this.bd = bd;
	}
	
	public Tarea comprobarTarea(int id) {
		for(Tarea t : listaTareas) {
			if(t.getId()==id) {
				System.out.println("Ya existe esta tarea");
				return t;
			}
		}
		return null;
	}
	
	public Tarea nuevaTarea(int id, String descripcion, String fechaInicio, String fechaFin, boolean finalizada, TipoTarea tipoTarea) {
		Tarea tarea = comprobarTarea(id);
		if(tarea == null) {
			tarea = new Tarea(id, descripcion, fechaInicio, fechaFin, finalizada, tipoTarea);
			listaTareas.add(tarea);
			bd.odb.store(tarea);
			bd.odb.commit();
			System.out.println("Nueva Tarea");
		}
		return tarea;
	}

	@Override
	public void close() {
		if(bd!=null) {
			bd.close();
		}
		
	}
	
}
