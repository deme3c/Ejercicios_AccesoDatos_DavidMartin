package Tema3;

import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.oid.OIDFactory;

public class Ejercicio_3_1_1_BBDD implements AutoCloseable {

	ODB odb = null;

	
	public Ejercicio_3_1_1_BBDD() {
		odb = ODBFactory.open("./db/ejercicio_3_1_1.db");
	}
	
	public void obtenerObjetoMedianteID(int id) {
		OID oid = OIDFactory.buildObjectOID(id);
		Tarea tarea = (Tarea)odb.getObjectFromId(oid);
		System.out.println(tarea);
	}
	
	public void mostrarTareas() {
		Objects<Tarea>tareas = odb.getObjects(Tarea.class);
		while(tareas.hasNext()) {
			Tarea tarea = tareas.next();
			System.out.println(tarea);
		}
	}
	
	public void mostrarTipoTarea() {
		Objects<TipoTarea>tipoTareas = odb.getObjects(TipoTarea.class);
		while(tipoTareas.hasNext()) {
			TipoTarea tipos = tipoTareas.next();
			System.out.println(tipos);
		}
	}

	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if(odb!=null && !odb.isClosed()) {
			odb.close();
		}
	}
	
	
}
