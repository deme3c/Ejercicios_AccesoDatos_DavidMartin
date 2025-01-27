package manejoobjetos3;

public class TipoTarea {

	private int tarea;
	private String abreviatura;
	private String descripcion;
	
	public TipoTarea(int tarea, String abreviatura, String descripcion) {
		super();
		this.tarea = tarea;
		this.abreviatura = abreviatura;
		this.descripcion = descripcion;
	}

	public int getTarea() {
		return tarea;
	}

	public void setTarea(int tarea) {
		this.tarea = tarea;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoTarea [tarea=" + tarea + ", abreviatura=" + abreviatura + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
