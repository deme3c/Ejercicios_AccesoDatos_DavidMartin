package Tema1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Ejercicio 3.2.2 
 * Se modifica la solución del Ejercicio 3.2.1 para que, en lugar de guardar la información mediante un clase de tipo ObjectOutputStream, 
 * se emplee una clase de tipo DataOutputStream. Respecto a la lectura de información del fichero, 
 * en lugar de emplear la clase ObjectInputStream, se empleará la clase DataInputStream.
 * Emplea métodos de Test para la ejecución de los dos métodos implicados. 
 * Se añadirá al menos la información de tres coches al fichero.
 */
public class Ejercicio_3_2_2 {
	public void guardarCoche(String[] matricula, String[] modelo, int[] anioMatriculacion) {

		try {
			FileOutputStream fos = new FileOutputStream("./tmp/coche322.obj.", true);
			DataOutputStream dos = new DataOutputStream(fos);

			for (int i=0; i<matricula.length;i++) {
				dos.writeUTF(matricula[i]);
				dos.writeUTF(modelo[i]);
				dos.writeInt(anioMatriculacion[i]);
			}
			
			dos.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void leerCoches(){

		try {
			FileInputStream fis = new FileInputStream("./tmp/coche322.obj.");
			DataInputStream dis = new DataInputStream(fis);

			Coche c = null;
			boolean salir = false;
			while (!salir) {
                try {
                    String matricula = dis.readUTF();
                    String marca = dis.readUTF();
                    int anyoMatriculacion = dis.readInt();
                    c = new Coche(matricula, marca, anyoMatriculacion);
                    System.out.println(c);
                } catch (Exception e) {
                    salir = true;
                }
            }
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

//class Coche implements java.io.Serializable {
//
//	private static final long serialVersionUID = 1L;
//	String matricula;
//	String marca;
//	int yearMatriculacion;
//
//	public Coche(String matricula, String marca, int anyoMatriculacion) {
//		this.matricula = matricula;
//		this.marca = marca;
//		this.yearMatriculacion = anyoMatriculacion;
//	}
//
//	public String getMatricula() {
//		return matricula;
//	}
//
//	public String getMarca() {
//		return marca;
//	}
//
//	public int getAnyoMatriculacion() {
//		return yearMatriculacion;
//	}
//
//	public void setMatricula(String matricula) {
//		this.matricula = matricula;
//	}
//
//	public void setMarca(String marca) {
//		this.marca = marca;
//	}
//
//	public void setAnyoMatriculacion(int anyoMatriculacion) {
//		this.yearMatriculacion = anyoMatriculacion;
//	}
//
//	@Override
//	public String toString() {
//		return "Coche [matricula=" + matricula + ", marca=" + marca + ", anyoMatriculacion=" + yearMatriculacion + "]";
//	}
//}

