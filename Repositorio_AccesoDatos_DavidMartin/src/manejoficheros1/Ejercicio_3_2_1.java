package manejoficheros1;

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

	public void guardarCoche(String[] matricula, String[] modelo, int[] anioMatriculacion) {

		try {
			FileOutputStream fos = new FileOutputStream("./tmp/coche.obj.", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (int i = 0; i < matricula.length; i++) {
				Coche coche = new Coche(matricula[i], modelo[i], anioMatriculacion[i]);
				oos.writeObject(coche);
			}

			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void leerCoches() {

		try {
			FileInputStream fis = new FileInputStream("./tmp/coche.obj.");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Coche c = null;
			boolean salir = false;
			while (!salir) {
				try {
					c = (Coche) ois.readObject();
				} catch (Exception e) {
					salir = true;
				}
				if (!salir) {
					System.out.println(c);
					
				}
			}

			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			// End of file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


