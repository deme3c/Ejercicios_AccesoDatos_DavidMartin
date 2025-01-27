package manejoobjetos3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.platform.engine.support.hierarchical.ThrowableCollector.Factory;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.oid.OIDFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Ejercicio_3_3_1_BBDD implements AutoCloseable{

	ODB odb = null;
	
	public Ejercicio_3_3_1_BBDD(String pathBD) {
		odb = ODBFactory.open(pathBD);
	}
	
	public List<Tarea> mostrarTareasConDescripcion(String cadena) {
		
		List<Tarea>listaTareas = new ArrayList<Tarea>();

		ICriterion criterio = Where.like("descripcion", "%" + cadena + "%");
		IQuery query = new CriteriaQuery(Tarea.class, criterio);
		Objects<Tarea>objects = odb.getObjects(query);
		
		while(objects.hasNext()) {
			Tarea tarea = objects.next();
			listaTareas.add(tarea);
		}
		return listaTareas;
	}
	
	
	public List<Tarea> mostrarFechasIncluidas(Date fecha1, Date fecha2){
		List<Tarea>listaTareas = new ArrayList<Tarea>();
		ICriterion criterio = new And().add(Where.ge("fechaInicio", fecha1)).add(Where.le("fechaFin", fecha2));
		IQuery query = new CriteriaQuery(Tarea.class, criterio);
		Objects<Tarea>objects = odb.getObjects(query);
		
		while(objects.hasNext()) {
			Tarea tarea = objects.next();
			listaTareas.add(tarea);
		}
		return listaTareas;
	}
	
	public List<Tarea>mostrarFechasExcluidas(Date fecha1, Date fecha2){
		List<Tarea>listaTareas = new ArrayList<Tarea>();
		ICriterion criterio = new And().add(Where.gt("fechaInicio", fecha1)).add(Where.lt("fechaFin", fecha2));
		IQuery query = new CriteriaQuery(Tarea.class, criterio);
		Objects<Tarea>objects = odb.getObjects(query);
		
		while(objects.hasNext()) {
			Tarea tarea = objects.next();
			listaTareas.add(tarea);
		}
		return listaTareas;
		
	}
	
	
	public void modificarFinalizada(int id, boolean nuevoEstado) {
		List<Tarea>listaTareas = new ArrayList<Tarea>();
		ICriterion criterio = Where.equal("id", id);
		IQuery query = new CriteriaQuery(Tarea.class, criterio);
		Objects<Tarea>objects = odb.getObjects(query);
		
		while(objects.hasNext()) {
			Tarea tarea = objects.next();
			listaTareas.add(tarea);
		}
		
		Tarea tarea = listaTareas.get(0);
		tarea.setFinalizada(nuevoEstado);
		odb.store(tarea);
		odb.commit();
	}

	@Override
	public void close() throws Exception {
		if(odb!=null && odb.isClosed()) {
			odb.close();
		}
		
	}
	
	
}
