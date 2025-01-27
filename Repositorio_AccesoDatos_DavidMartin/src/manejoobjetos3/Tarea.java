package manejoobjetos3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarea {

	private int id;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private boolean finalizada;
	private TipoTarea tipoTarea;
	
	public Tarea(int id, String descripcion, String fechaInicio, String fechaFin, boolean finalizada, TipoTarea tipoTarea) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		
		try {
			this.fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.fechaFin = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.finalizada = finalizada;
		this.tipoTarea = tipoTarea;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	public TipoTarea getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(TipoTarea tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", finalizada=" + finalizada + ", tipoTarea=" + tipoTarea + "]";
	}
	

	
	
	
	
	
}
