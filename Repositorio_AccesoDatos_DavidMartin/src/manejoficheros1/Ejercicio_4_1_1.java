package manejoficheros1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ejercicio_4_1_1 {

	public void mostrarInformacionPorMatricula(String matricula) {

		try {
			FileInputStream fis = new FileInputStream("./tmp/coche.obj.");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Coche c = null;
			boolean salir = false;
			while (!salir) {
				try {
					c = (Coche) ois.readObject();
					if (c.getMatricula().equals(matricula)) {
						System.out.println(c);
						salir = true;
					}
				} catch (Exception e) {
					salir = true;
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

// appendChild para emparejar los nodos con el xml
