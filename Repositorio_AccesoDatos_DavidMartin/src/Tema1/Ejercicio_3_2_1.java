package Tema1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * 
Ejercicio 3.2.1 Implementa una clase para el ejercicio con un método que serialice y guarde en fichero 
un objeto de la clase coche. La clase coche constará de los atributos matrícula, marca y año de matriculación. 
El método tendrá como parámetros estos mismos atributos.
Implementa otro método cuya finalidad sea la lectura de la información de todos los coches registrados en fichero.
Emplea métodos de Test para la ejecución de ambos métodos. Se añadirán al menos tres coches al fichero.

 */
public class Ejercicio_3_2_1 {

	public void guardarCoche(String matricula, String marca, int anyoMatriculacion) {

		Coche coche = new Coche(matricula, marca, anyoMatriculacion);

		try {
			FileOutputStream fos = new FileOutputStream("./coche.obj.", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(coche);
			oos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void leerCoches() {

		try {
			FileInputStream fis = new FileInputStream("./coche.obj.");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Coche cOut = (Coche) ois.readObject();
			System.out.println(cOut.toString());
		

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			// End of file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}



	class Coche implements java.io.Serializable {

		private static final long serialVersionUID = 1L;
		String matricula;
		String marca;
		int yearMatriculacion;

		public Coche(String matricula, String marca, int anyoMatriculacion) {
			this.matricula = matricula;
			this.marca = marca;
			this.yearMatriculacion = anyoMatriculacion;
		}

		public String getMatricula() {
			return matricula;
		}

		public String getMarca() {
			return marca;
		}

		public int getAnyoMatriculacion() {
			return yearMatriculacion;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public void setAnyoMatriculacion(int anyoMatriculacion) {
			this.yearMatriculacion = anyoMatriculacion;
		}

		@Override
		public String toString() {
			return "Coche [matricula=" + matricula + ", marca=" + marca + ", anyoMatriculacion=" + yearMatriculacion
					+ "]";
		}
	}
	



	