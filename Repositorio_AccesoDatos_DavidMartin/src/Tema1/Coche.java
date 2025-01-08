package Tema1;

public class Coche {

	private String matricula;
	private String modelo;
	private int anioMatriculacion;
	
	public Coche(String matricula, String modelo, int anioMatriculacion) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.anioMatriculacion = anioMatriculacion;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnioMatriculacion() {
		return anioMatriculacion;
	}

	public void setAnioMatriculacion(int anioMatriculacion) {
		this.anioMatriculacion = anioMatriculacion;
	}
	
	
	
	
}
